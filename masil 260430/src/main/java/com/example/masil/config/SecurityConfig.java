package com.example.masil.config;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable()) // CSRF 보호 비활성화 (API 테스트용)
//                .authorizeHttpRequests(auth -> auth
//                        .anyRequest().permitAll() // 모든 요청을 로그인 없이 허용
//                );
////                .headers(headers -> headers.frameOptions(frame -> frame.disable())); // h2-console 등 사용 시 필요
//        http
//                .authorizeHttpRequests((auth) -> auth
//                        .requestMatchers("/").permitAll()
//                        .requestMatchers("/css/**", "/js/**", "/images/**", "/favicon.ico").permitAll()
//                        .requestMatchers("/question/**").permitAll()
//                        .anyRequest().permitAll()
//                );
//
//        return http.build();
//    }
//}



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // API 테스트를 위해 CSRF 끄기
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // 🌟 '모든 요청 허용'을 하나만 깔끔하게 설정!
                )
                .headers(headers -> headers.frameOptions(f -> f.disable())); // DB 관리창 등을 위해 필요

        return http.build();
    }
}