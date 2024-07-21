package com.collega.otomasi_datacenter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.collega.otomasi_datacenter.service.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final JwtRequestFilter jwtRequestFilter;
    private final CustomUserDetailService customUserDetailService;
    private final CustomAccessDeniedHandler customAccessDeniedHandler;

    public SecurityConfig(JwtRequestFilter jwtRequestFilter, CustomUserDetailService customUserDetailService, 
        CustomAccessDeniedHandler customAccessDeniedHandler){
        this.jwtRequestFilter = jwtRequestFilter;
        this.customUserDetailService = customUserDetailService;
        this.customAccessDeniedHandler = customAccessDeniedHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        // System.out.println("Security Filter Chain Executed!");
        http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests((req) -> 
                req.requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/api/super-admin/**").hasAuthority("SUPER_ADMIN")
                .requestMatchers("/api/operator/**").hasAnyAuthority("OPERATOR", "SUPER_ADMIN")
                .requestMatchers("/api/manager/**").hasAnyAuthority("MANAGER", "SUPER_ADMIN")
                .requestMatchers("/api/supervisor/**").hasAnyAuthority("SUPERVISOR", "SUPER_ADMIN")
                .requestMatchers("/api/user-dept/**").hasAnyAuthority("USER_DEPARTMENT", "SUPER_ADMIN")
                .requestMatchers("/api/user-div/**").hasAnyAuthority("USER_DIVISI", "SUPER_ADMIN")
                .anyRequest().authenticated()
            )
            .sessionManagement((session) ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            ).exceptionHandling(exception -> exception.accessDeniedHandler(customAccessDeniedHandler));
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }
}
