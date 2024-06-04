package com.example.ex.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberDetailService implements UserDetailsService {
	
	private final MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// username => member.id
		Optional<Member> _member = this.memberRepository.findById(username); // 해당 id인 계정 검색
		if(_member.isEmpty()) { // 해당 id인 계정 없음
			throw new UsernameNotFoundException("아이디를 확인해 주세요.");
		}
		
		Member member = _member.get();
		List<GrantedAuthority> authorities = new ArrayList<>();
		if(!username.equals("admin")) { // id가 admin이 아니면 해당 회원의 권한은 일반회원
			authorities.add(new SimpleGrantedAuthority("일반"));
		}
		return new User(member.getId(), member.getPw(), authorities);
	}

}
