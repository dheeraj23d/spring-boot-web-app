package com.dheeraj.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration      // mention it as a configuration class
@EnableWebSecurity  // mention spring to consider this config class upon the config properties file
public class SecurityConfig {

    @Autowired
    public UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        return http.csrf(customizer -> customizer.disable())
        .authorizeHttpRequests(req -> req
                .requestMatchers("register", "login")   // excluding these 2 web pages/paths from authentication as they should be served without user authentication
                .permitAll()
                .anyRequest().authenticated())
        //http.formLogin(Customizer.withDefaults());
        .httpBasic(Customizer.withDefaults())  // in postman we get form html as response for localhost:8080 GET. to make it work in postman too, enable this
        /*  What It Does
            Purpose: Configures Spring Security to use HTTP Basic authentication for incoming requests.
            Effect: When a client sends a request to a secured endpoint, the server will:
            Respond with a 401 Unauthorized status if no credentials are provided.
            Prompt the user to provide a username and password using the WWW-Authenticate header.
            Authenticate the credentials (usually against an in-memory, database, or external user store).
            The Customizer.withDefaults() is a convenience method that applies default settings for HTTP Basic authentication without requiring additional customization.   */

        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))   // make http stateless. session id is not needed but each time we need to send the user creds as http headers. we need to disable the form login for this (line no 19)
        .build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user1 = User
//                .withDefaultPasswordEncoder()
//                .username("kiran")
//                .password("k@123")
//                .roles("User")
//                .build();
//
//        UserDetails user2 = User
//                .withDefaultPasswordEncoder()
//                .username("Dheeraj")
//                .password("d@123")
//                .roles("Admin")
//                .build();
//        return new InMemoryUserDetailsManager(user1, user2);
//    }


    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));     // validating the password by creating user given password to hash with 12 strength and comparing it
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
