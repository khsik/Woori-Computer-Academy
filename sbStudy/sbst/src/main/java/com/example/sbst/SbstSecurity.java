package com.example.sbst;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration // 환경설정파일
@EnableWebSecurity // 모든 요청 URL 제어
public class SbstSecurity {

	@Bean // 스프링이 객체 관리
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception { // 필터 설정
		http.
			// 인증되지 않은 모든 페이지 접근 허용
			authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
				.requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
			// csrf 검증 예외 설정
			.csrf(csrf -> csrf
				.ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console")))
			// 같은 도메인의 다른 사이트 포함 허용
			.headers(headers -> headers
				.addHeaderWriter(new XFrameOptionsHeaderWriter(
					XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
			.formLogin(formLogin -> formLogin
				.loginPage("") // 로그인 페이지 uri
				.defaultSuccessUrl("") // 로그인 성공시 보내는 페이지 uri
				.usernameParameter("") // id 파라미터명, 기본 username
				.passwordParameter("")) // pw 파라미터명 기본 password
			.logout(logout -> logout
				// logoutUrl() 단순히 특정 URL로 로그아웃 기능 구현할 때
				// logoutRequestMatcher() 다양한 특성으로 로그아웃 요청 매칭할때 
				.logoutRequestMatcher(new AntPathRequestMatcher("")) // 로그아웃 페이지 uri
				.logoutSuccessUrl("") // 로그아웃 성공시 가는 uri
				.invalidateHttpSession(true)) // 세션 삭제
		;
		
		return http.build();
	}
}
