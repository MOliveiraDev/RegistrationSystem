package com.example.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class Config {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Desabilita CSRF para APIs RESTful
                .authorizeHttpRequests()
                .requestMatchers("/usuarios/cadastrar").permitAll() // Permite acesso ao cadastro sem autenticação
                .anyRequest().authenticated(); // Todas as outras requisições exigem autenticação
        return http.build();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
         @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") //Permite CORS em todas as requisições
                        .allowedOrigins("http://localhost:8080") //Permite acesso ao Front-End
                        .allowedMethods("GET", "POST", "PUT", "DELETE"); //Permite os métodos GET, POST, PUT e DELETE
            }
        };
    }
}
