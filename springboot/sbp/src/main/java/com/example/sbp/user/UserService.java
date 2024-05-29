package com.example.sbp.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	// SecurityConfig 에서 객체를 주입받아 사용
	
	public SiteUser create(String username, String pw, String email) {
		SiteUser user = new SiteUser();
		user.setUsername(username);
		user.setEmail(email);
		
		// 비밀번호 암호화
		user.setPw(passwordEncoder.encode(pw));
		
		this.userRepository.save(user);
		return user;
	}

}
