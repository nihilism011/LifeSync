package com.lifesync.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Security {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // authorizeHttpRequests :
        // HTTP 요청에 대한 권한을 설정하는 메소드
        //  웹사이트에 들어오는 요청을 누가 들어올 수 있는지, 어떤 행동을 할 수 있는지 설정하는 역할
        // requestMatchers :
        // 특정 URL 패턴을 지정하는 메소드
        // /admin/**는 /admin으로 시작하는 모든 경로
        // authenticated :
        // 로그인한 사용자만 해당 경로에 접근할 수 있도록 설정, 인증된 사용자는 누구든지 접근
        // ex) .requestMatchers("/user/**").authenticated();
        // anyRequest().denyAll() :
        // anyRequest()는 그 외의 모든 경로를 의미, denyAll()은 모든 요청을 거부
        // 즉, 위에 작성한 경로 외의 모든 요청은 접근을 차단
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/").permitAll()
//                                .requestMatchers("/student/**").hasRole("STUDENT")
//                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .anyRequest().permitAll()
                )

                .formLogin(formLoginConfig ->
                        formLoginConfig
                                .loginPage("/login")  // 커스텀 로그인 페이지 경로
                                .permitAll()  // 누구나 접근 가능
                )
                .logout(logoutConfig ->
                        logoutConfig
                                .logoutUrl("/logout")  // 커스텀 로그아웃 경로
                                .logoutSuccessUrl("/login?logout")  // 로그아웃 후 리디렉션할 URL
                                .permitAll()  // 누구나 로그아웃 경로에 접근 가능
                );
        return http.build();
    }
}
