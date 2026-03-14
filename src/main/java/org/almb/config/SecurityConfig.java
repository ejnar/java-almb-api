package org.almb.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

/*    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        *//*http
                // Disable CSRF for simplicity (use only for APIs)
                .csrf(csrf -> csrf.disable())

                // Authorize requests
                .authorizeHttpRequests(auth -> auth
                        // Allow public access to Swagger and H2 console
                        .requestMatchers("/swagger-ui/**", "/h2-console/**").permitAll()
                        // All other requests need authentication
                        .anyRequest().authenticated()
                );
                // Enable HTTP Basic authentication
                // .httpBasic();
        // Allow H2 console to be loaded in browser frames
        http.headers(headers -> headers.frameOptions(frame -> frame.disable()));*//*
        return http.build();
    }*/
}
