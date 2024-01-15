package br.com.danieleleao.front_gestao_vagas.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/candidate/login").permitAll()
                            .requestMatchers("/candidate/signIn").permitAll();
                    auth.anyRequest().authenticated();
                })
                .formLogin(form -> form.loginPage("/candidate/login"));
        return http.build();
    }
}
