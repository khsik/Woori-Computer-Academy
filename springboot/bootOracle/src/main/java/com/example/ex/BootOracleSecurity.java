package com.example.ex;

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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class BootOracleSecurity {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(authorizeHttpResuests -> authorizeHttpResuests
					.requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
			.formLogin(formLogin -> formLogin
					.loginPage("/member/login")
					.defaultSuccessUrl("/")
					.usernameParameter("id")
					.passwordParameter("pw"))
			.logout(logout -> logout
//					.logoutUrl("/member/logout") // 이거로 하면 html 필요한거로 보임. NoResourceFoundException 발생함.
					.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
					.logoutSuccessUrl("/")
					.invalidateHttpSession(true))
		;
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager authenticationManeger(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
}
