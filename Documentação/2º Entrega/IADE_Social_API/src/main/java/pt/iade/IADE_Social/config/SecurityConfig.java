package pt.iade.IADE_Social.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import pt.iade.IADE_Social.service.impl.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF protection
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/users/signup", "/api/users/login", "api/users").permitAll()  //"/api/users"
                .anyRequest().authenticated()       //.permitAll()//.authenticated()
            )
            .httpBasic(httpBasic -> {});
            //.formLogin(form -> form.loginPage("/api/users/login").permitAll() ) 
            //.logout(logout -> logout.permitAll()) 
            //.sessionManagement(session -> session .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED) );

        return http.build();
    }

    @Bean 
    public UserDetailsService userDetailsService() { return new CustomUserDetailsService(); }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
