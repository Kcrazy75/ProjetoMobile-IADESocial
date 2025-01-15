package pt.iade.IADESocial.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET_KEY = "YourSuperSecretKeyForJWTToken12345"; // Chave secreta para gerar o token, deve ter pelo menos 32 caracteres

    // Método para gerar o token JWT
    public String generateToken(String email) {
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // O token expira em 1 hora
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Método para validar o token (opcional, pode ser útil para autenticação de usuários)
    public boolean validateToken(String token) {
        try {
            Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);  // Isso valida o token e verifica sua assinatura
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Método para extrair o email do token (opcional, pode ser útil para obter informações do usuário)
    public String extractEmail(String token) {
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();  // Retorna o email contido no subject do JWT
    }
}
