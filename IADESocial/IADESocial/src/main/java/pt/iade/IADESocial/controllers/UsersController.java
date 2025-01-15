package pt.iade.IADESocial.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pt.iade.IADESocial.models.Users;
import pt.iade.IADESocial.models.LoginRequestDTO;
import pt.iade.IADESocial.models.LoginResponseDTO;
import pt.iade.IADESocial.models.repositories.UsersRepository;
import pt.iade.IADESocial.services.JwtService;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/users")
public class UsersController {
    private final Logger logger = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private JwtService jwtService;

    // Chave secreta para assinar os tokens JWT
    private static final String SECRET_KEY = "YourSuperSecretKeyForJWTToken12345";

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Users> getUsers() {
        logger.info("Sending all the users");
        return userRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Users> getUser(@PathVariable int id) {
        logger.info("Sending user with id {}", id);
        return userRepository.findById(id);
    }

    // Registro de usuário
    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Users registerUser(@Valid @RequestBody Users newUser) {
        logger.info("Registering a new user: {}", newUser.getEmail());

        // Verificar se o e-mail já existe
        if (userRepository.findByEmail(newUser.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already in use");
        }

        // Implementação de hashing de senha
        newUser.setPassword(newUser.getPassword()); // Em produção, use um algoritmo de hashing seguro

        return userRepository.save(newUser);
    }

    // Login de usuário
    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginResponseDTO loginUser(@RequestBody LoginRequestDTO loginRequest) {
        logger.info("Authenticating user: {}", loginRequest.getEmail());

        Optional<Users> userOpt = userRepository.findByEmail(loginRequest.getEmail());
        if (userOpt.isPresent()) {
            Users user = userOpt.get();
            if (user.getPassword().equals(loginRequest.getPassword())) {
                // Gerando o token para o usuário autenticado
                String token = jwtService.generateToken(user.getEmail());
                return new LoginResponseDTO(user.getId(), token);
            } else {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid password");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    // Método auxiliar para gerar o token JWT
    private String generateToken(Users user) {
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("id", user.getId())
                .claim("username", user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // Token válido por 24 horas
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Endpoint para validar o token JWT
    @GetMapping(path = "/validate", produces = MediaType.APPLICATION_JSON_VALUE)
    public String validateToken(@RequestHeader("Authorization") String token) {
        try {
            // Remover o prefixo "Bearer " se estiver presente
            if (token.startsWith("Bearer ")) {
                token = token.substring(7);  // Remove o prefixo "Bearer "
            }

            // Validar o token JWT
            if (jwtService.validateToken(token)) {
                return "Token is valid";
            } else {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid or expired token");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid or expired token");
        }
    }
}
