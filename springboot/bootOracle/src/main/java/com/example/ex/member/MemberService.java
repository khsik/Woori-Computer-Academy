package com.example.ex.member;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ex.board.Board;
import com.example.ex.board.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

	private final MemberRepository memberRepository;
	private final BoardRepository boardRepository;
	private final PasswordEncoder passwordEncoder;
	
	public boolean overlapId(String id) { // id 중복 검사
		boolean pass = true;
		if(this.memberRepository.findById(id).isEmpty()) { // 중복된 id가 없다면
			pass = false;
		}
		return pass;
	}
	
	public boolean overlapEmail(String email) { // email 중복 검사
		boolean pass = true;
		if(this.memberRepository.findByEmail(email).isEmpty()) { // 중복된 email 없다면
			pass = false;
		}
		return pass;
	}
	
	public boolean overlapEmail2(String email, String memEmail) { // email 중복 검사
		boolean pass = true;
		Optional<Member> om = this.memberRepository.findByEmail(email);
		if(om.isEmpty()) { // 중복된 email 없다면
			pass = false;
		}else if(om.get().getEmail().equals(memEmail)) { // email 변경 안한다면
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
	
	public Member getMember(String id) { // 회원 id로 회원 정보 검색
		Optional<Member> member = this.memberRepository.findById(id);
		return member.get();
	}
	
	public void dropMember(Member member) { // 회원 탈퇴
		// 회원 삭제하기 전에 해당 회원을 포린키로 사용하는 데이터 삭제
		List<Board> list = this.boardRepository.findByWriter(member);
		for(Board b : list) {
			this.boardRepository.delete(b);
		}
		this.memberRepository.delete(member); // 회원 정보 삭제
	}
	
	public void updateMember(Member member) { // 회원 정보 수정
		this.memberRepository.save(member);
	}
	
	public String findByEmail(String email) { // email로 member 정보 검색
		Optional<Member> member = this.memberRepository.findByEmail(email);
		String id = null;
		if(member.isPresent()) {
			id = member.get().getId();
		}
		return id;
	}
	
	public void findpw(String id, String pw) { // pw 재설정
		Member member = this.memberRepository.findById(id).get();
		member.setPw(this.passwordEncoder.encode(pw));
		this.memberRepository.save(member);
	}
}
