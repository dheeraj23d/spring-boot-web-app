package com.dheeraj.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration      // mention it as a configuration class
@EnableWebSecurity  // mention spring to consider this config class upon the config properties file
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.csrf(customizer -> customizer.disable());
        http.authorizeHttpRequests(req -> req.anyRequest().authenticated());
        //http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());  // in postman we get form html as response for localhost:8080 GET. to make it work in postman too, enable this
        /*  What It Does
            Purpose: Configures Spring Security to use HTTP Basic authentication for incoming requests.
            Effect: When a client sends a request to a secured endpoint, the server will:
            Respond with a 401 Unauthorized status if no credentials are provided.
            Prompt the user to provide a username and password using the WWW-Authenticate header.
            Authenticate the credentials (usually against an in-memory, database, or external user store).
            The Customizer.withDefaults() is a convenience method that applies default settings for HTTP Basic authentication without requiring additional customization.   */

        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));   // make http stateless. session id is not needed but each time we need to send the user creds as http headers. we need to disable the form login for this (line no 19)
        return http.build();
    }
}
