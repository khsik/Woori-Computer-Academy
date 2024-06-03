package com.example.ex.member;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	
	public boolean overlap(String id) { // id 중복 검사
		boolean pass = true;
		if(this.memberRepository.findById(id).isEmpty()) { // 중복된 id가 없다면
			pass = false;
		}
		return pass;
	}
	
	public void joinMember(MemberCreateForm memberCreateForm) { // 회원 가입 (저장)
		Member member = new Member();
		member.setId(memberCreateForm.getId());
		member.setPw( passwordEncoder.encode(memberCreateForm.getPw()) );
		member.setEmail(memberCreateForm.getEmail());
		member.setGender(memberCreateForm.getGender());
		member.setCountry(memberCreateForm.getCountry());
		member.setHobbies(memberCreateForm.getHobbies());
		this.memberRepository.save(member);
	}
	
	public Member getMember(String id) {
		Optional<Member> member = this.memberRepository.findById(id);
		return member.get();
	}
}
