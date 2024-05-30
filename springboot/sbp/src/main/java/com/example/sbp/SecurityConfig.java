package com.example.sbp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration // 이 파일이 스프링 환경설정 파일
@EnableWebSecurity // 모든 요청 URL이 스프링 시큐리티의 제어를 받도록 만듬
@EnableMethodSecurity(prePostEnabled = true) // @PreAuthorize 사용하기 위한 설정
public class SecurityConfig {

	@Bean // 스프링에서 객체 생성, 관리
	// 필터체인을 정의하는 메서드
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
			// 요청을 허용할지 결정하는 설정
			.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
					// 모든 요청을 허용
					.requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
			.csrf((csrf) -> csrf
					.ignoringRequestMatchers(new AntPathRequestMatcher
							("/h2-console/**")))
			.headers((headers) -> headers
					.addHeaderWriter(new XFrameOptionsHeaderWriter(
							XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
			.formLogin((formLogin) -> formLogin
					.loginPage("/user/login")
					.defaultSuccessUrl("/question/list")
//					.loginProcessingUrl("/user/login") // 해당하는 url로 접근시 로그인의 기능이 작동, request되는 값을 컨트롤러가 아닌 이곳으로 넘겨받음.
//					.usernameParameter("username")	// default = username 파라미터로 넘어오는 값의 이름을 설정
                    .passwordParameter("pw"))		// default = password
			.logout((logout) -> logout
	                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
	                .logoutSuccessUrl("/question/list")
	                .invalidateHttpSession(true))
			;
		return http.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager authenticationManager(
			AuthenticationConfiguration authenticationConfiguration) throws Exception{
		return authenticationConfiguration.getAuthenticationManager();
	}
	
}
