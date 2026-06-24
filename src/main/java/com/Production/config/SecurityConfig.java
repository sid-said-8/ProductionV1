package com.Production.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{

        http.csrf(csrf->csrf.disable()).cors(cors->cors.disable());

        http.authorizeHttpRequests(auth->auth.requestMatchers
                                ("/api/v1/production/user/allUser","/api/v1/production/user/signup")
                        .permitAll().anyRequest().authenticated());

        return http.build();
    }

}
