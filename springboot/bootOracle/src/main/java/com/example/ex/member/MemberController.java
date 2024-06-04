package com.example.ex.member;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MemberController {

	private final MemberService memberService;
	private final PasswordEncoder passwordEncoder;

	// 메인
	@GetMapping("/main")
	public String goMain() {
		return "main";
	}

	// 메인
	@GetMapping("/")
	public String goMain2() {
		return "redirect:/main";
	}

	// 회원 가입
	@GetMapping("/member/join")
	public String join(MemberCreateForm memberCreateForm) {
		return "/member/join";
	}

	// 회원 가입
	@PostMapping("/member/join")
	public String join(@Valid MemberCreateForm memberCreateForm, BindingResult bindingResult) {
		if (!memberCreateForm.getPw().equals(memberCreateForm.getPw2())) { // 비밀번호 확인
			bindingResult.reject("password double check", "두 비밀번호가 일치하지 않습니다.");
		}
		if (this.memberService.overlapId(memberCreateForm.getId())) { // id 중복
			bindingResult.reject("id overlap check", "이미 사용중인 아이디 입니다.");
		}
		if (this.memberService.overlapEmail(memberCreateForm.getEmail())) { // email 중복
			bindingResult.reject("email overlap check", "이미 사용중인 이메일 입니다.");
		}
		if (bindingResult.hasErrors()) { // 에러가 있으면 가입x
			return "/member/join";
		}

		this.memberService.joinMember(memberCreateForm); // 에러가 없으면 가입o
		return "redirect:/main";
	}

	// 로그인
	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
	}

	// 회원 정보
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/member/info")
	public String info(Model model, Principal principal) {
		Member member = this.memberService.getMember(principal.getName()); // 로그인 한 회원의 정보 찾기
		model.addAttribute("member", member); // 뷰에 데이터 전달
		return "/member/info";
	}

	// 회원 탈퇴
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/member/drop")
	public String drop() {
		return "/member/drop";
	}

	// 회원 탈퇴
	@PostMapping("/member/drop")
	public String pwcheck2(Principal principal, @RequestParam("pw") String pw, RedirectAttributes rttr) {
		Member member = this.memberService.getMember(principal.getName());
		if(this.passwordEncoder.matches(pw, member.getPw())) { // 비밀번호 일치
			this.memberService.dropMember(member); // 테이블에서 삭제
			return "redirect:/member/logout"; // 탈퇴하면 로그아웃 처리
		}else { // 비밀번호 다름
			rttr.addFlashAttribute("msg", "비밀번호를 확인해 주세요."); // 비밀번호 틀렸을 때 출력하기 위한 문구
			return "redirect:/member/drop";
		}
	}

	// 회원 정보 수정
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/member/modify")
	public String modify(Model model, Principal principal, MemberModifyForm mmf) {
		Member member = this.memberService.getMember(principal.getName()); // 로그인 회원 정보 검색
		model.addAttribute("member", member); // 뷰에 데이터 전달
		return "/member/modify";
	}
	
	// 회원 정보 수정
	@PostMapping("/member/modify")
	public String modify(Model model, Principal principal, @Valid MemberModifyForm mmf, BindingResult bindingResult) {
		Member member = this.memberService.getMember(principal.getName());
		model.addAttribute("member", member);
		boolean npw = false;	// 변경 비밀번호 입력했다면 true
		boolean npw2 = false;	// 변경 비밀번호 확인 입력했다면 true
		
		// 유효성 검사
		if(!this.passwordEncoder.matches(mmf.getPw(), member.getPw())) { // 비밀번호 검사
			bindingResult.reject("pw incorrect", "기존 비밀번호를 확인해 주세요.");
		}
		if (this.memberService.overlapEmail2(mmf.getEmail(), member.getEmail())) { // email 중복 검사
			bindingResult.reject("email overlap check", "이미 사용중인 이메일 입니다.");
		}
		if(!mmf.getNpw().equals("")) { // 비밀번호 변경 검사. 공백이 아니면
			npw = true;
		}
		if(!mmf.getNpw2().equals("")) { // 비밀번호 변경 검사. 공백이 아니면
			npw2 = true;
		}
		if((npw || npw2) && (mmf.getNpw().length() < 6 || mmf.getNpw2().length() < 6)) {
			bindingResult.reject("Invalid new password","비밀번호는 6글자 이상으로 입력해주세요.");
		}
		if((npw ^ npw2) || (npw && npw2 && !mmf.getNpw().equals(mmf.getNpw2()))) { // 비밀번호 변경을 둘중 하나만 입력했거나, 두개가 일치하지 않으면
			bindingResult.reject("Invalid new password","변경할 비밀번호를 확인해주세요.");
		}
		if(bindingResult.hasErrors()) {
			return "/member/modify";
		}
		
		// 정보 변경 후 저장
		if(npw && npw2 && mmf.getNpw().equals(mmf.getNpw2())) { // 변경할 비밀번호를 입력했고, 비밀번호 확인도 일치하면
			member.setPw(passwordEncoder.encode(mmf.getNpw())); // 비밀번호 변경
		}
		member.setEmail(mmf.getEmail());
		member.setHobbies(mmf.getHobbies());
		this.memberService.updateMember(member); // 수정된 회원 정보 저장
		return "redirect:/member/info";
	}
	
	// 아이디 찾기
	@GetMapping("/member/findid")
	public String findId() {
		return "/member/findid";
	}
	
	// 아이디 찾기
	@PostMapping("/member/findid")
	public String findId(@RequestParam("email") String email, Model model) {
		// 검색 결과 없으면 String id = null
		String id = this.memberService.findByEmail(email); // email로 id 검색
		if(id != null) {
			model.addAttribute("id", id); // 검색된 id가 있으면 전달
		}
		return "/member/findid";
	}
	
	// 비밀번호 변경(id먼저 확인)
	@GetMapping("/member/findpw")
	public String findPw() {
		return "/member/findpw";
	}
	
	// 비밀번호 변경(id먼저 확인)
	@PostMapping("/member/findpw")
	public String findPw(@RequestParam("id") String id,@RequestParam("email") String email, RedirectAttributes rttr) {
		String mid = this.memberService.findByEmail(email);
		if(mid != null && mid.equals(id)) { // id, email 입력이 잘 들어와서 해당 멤버의 데이터가 있으면
			rttr.addFlashAttribute("id", id); // 어떤 계정인지도 정보가 필요하니까 데이터 전달.
			return "redirect:/member/findpw2";
		}else {
			return "/member/findpw";
		}
	}
	
	// 비밀번호 변경
	@GetMapping("/member/findpw2")
	public String findPw2(Model model, MemberPwForm memberPwForm) {
		return "/member/findpw2";
	}
	
	// 비밀번호 변경
	@PostMapping("/member/findpw2")
	public String findPw2(@ModelAttribute("id") String id, @Valid MemberPwForm memberPwForm, BindingResult bindingResult) {
		if(!memberPwForm.getPw().equals(memberPwForm.getPw2())) { // 비밀번호 2번 입력한거 검사
			bindingResult.rejectValue("pw2","passwordIncorrect", "비밀번호가 일치하지 않습니다.");
		}
		if(bindingResult.hasErrors()) { // 유효성 검사 통과 못하면
			return "/member/findpw2";
		}
		this.memberService.findpw(id, memberPwForm.getPw()); // 유효성 검사 통과했으면 새로운 비밀번호 설정
		
		return "redirect:/main";
	}
	
}
