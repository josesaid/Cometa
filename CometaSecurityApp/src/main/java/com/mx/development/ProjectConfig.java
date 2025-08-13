package com.mx.development;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author josesaidolanogarcia
 */
@Configuration
@EnableWebSecurity
public class ProjectConfig {
    private final CustomUserDetailsService customUserDetailsService;

    public ProjectConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(a -> a.requestMatchers("/admin").hasRole("ADMIN"))
                .authorizeHttpRequests(a -> a.requestMatchers("/user").hasRole("USER"))
                .authorizeHttpRequests(a -> a.requestMatchers("/customer").hasRole("CUSTOMER")
                        .anyRequest().authenticated()).formLogin(Customizer.withDefaults())
                .logout(l -> l.permitAll());
        return httpSecurity.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Bcrypt es bueno
        //return new BCryptPasswordEncoder();

        return new Argon2PasswordEncoder(16, 32, 1, 4096, 30);
    }

}
