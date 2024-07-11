package com.planner.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.planner.dto.request.member.MemberDTO;
import com.planner.dto.request.member.ReqChangePassword;
import com.planner.dto.request.member.ReqMemberRestore;
import com.planner.dto.request.member.ReqMemberUpdate;
import com.planner.dto.response.member.ResMemberDetail;
import com.planner.enums.FriendRole;
import com.planner.enums.Gender;
import com.planner.enums.Masking;
import com.planner.enums.MemberRole;
import com.planner.enums.MemberStatus;
import com.planner.exception.CustomException;
import com.planner.exception.ErrorCode;
import com.planner.service.EmailService;
import com.planner.service.FriendService;
import com.planner.service.MemberService;
import com.planner.util.CommonUtils;
import com.planner.util.UserData;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
//TODO - 이메일 체크 JS 까지 서윗알러트 바꿈
	private final MemberService memberService;
	private final FriendService friendService;
	private final EmailService emailService;

	// 회원가입 Get
	@GetMapping("/anon/insert")
	public String memberInsert() {
		return "/member/member_insert";
	}

	// 회원가입 Post
	@PostMapping("/anon/insert")
	public String memberInsert(@Valid MemberDTO memberDTO, RedirectAttributes rttr) {
		int result = memberService.memberInsert(memberDTO);
		rttr.addFlashAttribute("result", result);
		return "redirect:/planner/main";
	}

	/* 사용자 이메일로 인증코드 보내기 */
	@PostMapping("/anon/email/send")
	@ResponseBody
	public ResponseEntity<String> emailChk(@RequestParam(value = "toEmail") String toEmail,
			@RequestParam(value = "type") String type) throws MessagingException, UnsupportedEncodingException {
		memberService.memberChk(toEmail, type);
		emailService.sendAuthCode(toEmail);
		return ResponseEntity.ok("ok");
	}

	/* 인증코드 검증 */
	@PostMapping("/anon/code/chk")
	@ResponseBody
	public ResponseEntity<Long> authCodeChk(@RequestParam(value = "toEmail") String toEmail,
			@RequestParam(value = "authCode") String authCode) {
		ResMemberDetail member = memberService.formMember(toEmail);
		emailService.authCodeChk(toEmail, authCode);
		if (!CommonUtils.isEmpty(member)) {
			return ResponseEntity.ok(member.getMember_id());
		}
		return ResponseEntity.ok(1L); // 성공체크용으로 의미없는 값
	}

	/* 비밀번호 확인 폼 */
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/auth/pw/chk")
	public String passwordChkForm(@RequestParam(value = "url") String url, Model model) {
		model.addAttribute("url", url);
		return "/member/passwordChk";
	}

	/* 비밀번호 확인 */
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/auth/pw/chk")
	@ResponseBody
	public ResponseEntity<String> passwordChk(@RequestParam(value = "currentPw") String currentPw,
			@UserData ResMemberDetail member) {
		memberService.isPasswordValid(currentPw, member);
		return ResponseEntity.ok("성공");
	}

	/* 비밀번호 찾기 */
	@GetMapping("/anon/find/pw")
	public String findPwForm(@UserData ResMemberDetail detail, Model model) {
		if (!CommonUtils.isEmpty(detail)) {
			model.addAttribute("member_email", detail.getMember_email());
		}
		return "/member/member_find_pw";
	}

	/* 비밀번호 변경 폼 */
	@GetMapping("/anon/pw/change/{member_id}")
	public String pwChangeForm(@PathVariable(value = "member_id") Long member_id, Model model) {
		model.addAttribute("member_id", member_id);
		return "/member/member_change_pw";
	}

	/* 비밀번호 변경 */
	@PostMapping("/anon/pw/change")
	@ResponseBody
	public ResponseEntity<String> pwChange(@Valid ReqChangePassword req) {
		if (req.getNewPassword().equals(req.getNewPassword2())) {
			memberService.changePassword(req);
		}
		return ResponseEntity.ok("ok");
	}
	
	// 로그인
	@GetMapping("/anon/login")
	public String memberLogin(@UserData ResMemberDetail detail, HttpServletRequest request,
			HttpServletResponse response) {
		if (detail != null && detail.getMember_status().equals(MemberStatus.NOT_DONE.getCode())) {
			CommonUtils.removeCookiesAndSession(request, response);
			return "redirect:/member/anon/login";
		}
		return "/member/member_login";
	}

	/* 로그인시에 상태코드 검사 */
	@GetMapping("/auth")
	public String memberStatusChk(@UserData ResMemberDetail detail, HttpServletRequest request,
			HttpServletResponse response) {
		if (MemberRole.SUPER_ADMIN.getType().equals(detail.getMember_role())) {
			return "redirect:/admin/main";
		}
		memberService.memberStatusChk(detail.getMember_status(), request, response);
		return "redirect:/planner/main";
	}

	/* 로그인 실패시 매핑 */
	@GetMapping("/anon/fail")
	public void loginFail() {
		throw new CustomException(ErrorCode.NO_ACCOUNT);
	}

	/* 소셜로그인에서 생긴 쿠키 제거 후 로그아웃 */
	@GetMapping("/anon/signout")
	public String signout(HttpServletRequest request, HttpServletResponse response) {
		CommonUtils.removeCookiesAndSession(request, response);
		return "redirect:/member/logout";
	}

	// 내정보
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/auth/myInfo")
	public String myInfo(@UserData ResMemberDetail detail, Model model) {
		ResMemberDetail memberDTO = memberService.findMemberByLoginType(detail.getOauth_type(),
				detail.getMember_email());
		String gender;

		gender = Gender.findNameByCode(detail.getMember_gender());

		model.addAttribute("memberDTO", memberDTO);
		model.addAttribute("gender", gender);

		return "/member/member_myInfo";
	}

//	회원정보
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/auth/info/{member_id}")
	public String memberInfo(@PathVariable(value = "member_id") Long member_id, @UserData ResMemberDetail detail,
			Model model) {
		String gender;
		String name;
		int receive_count = 0;

		MemberDTO memberDTO = memberService.info(member_id, detail);
		gender = Gender.findNameByCode(memberDTO.getMember_gender());
		receive_count = friendService.receiveRequestCount(detail.getMember_email()); // 받은 친구신청 수

		name = Masking.maskAs(memberDTO.getMember_name(), Masking.NAME);
		model.addAttribute("name", name); // 마스킹 처리

		model.addAttribute("receive_count", receive_count);
		model.addAttribute("memberDTO", memberDTO);
		model.addAttribute("gender", gender);

		return "/member/member_info";
	}

	/* 회원정보 수정 폼 */
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/auth/update")
	public String memberUpdateForm(Model model, @UserData ResMemberDetail detail) {
		model.addAttribute("detail", detail);
		return "/member/member_update";
	}

	/* 회원정보 수정 */
	@PreAuthorize("isAuthenticated()")
	@PutMapping("/auth/update")
	public String memberUpdate(@Valid ReqMemberUpdate req) {
		memberService.memberUpdate(req);
		return "redirect:/member/auth/myInfo";
	}

	/* 회원 탈퇴 */
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/auth/delete")
	@ResponseBody
	public void memberDelete(@UserData ResMemberDetail detail, HttpServletRequest request,
			HttpServletResponse response) {
		CommonUtils.removeCookiesAndSession(request, response);
		memberService.memberDelete(detail.getMember_id());
	}

	/* 회원복구 폼 */
	@GetMapping("/anon/restore")
	public String memberRestoreForm() {
		return "/member/member_restore";
	}

	/* 회원 복구 */
	@PostMapping("/anon/restore")
	@ResponseBody
	public ResponseEntity<Integer> memberRestore(@Valid ReqMemberRestore req) {
		int result = memberService.memberRestore(req);
		return ResponseEntity.ok(result);
	}

	/*
	 * 쭈썽이햄-------------------------------------------------------------------------
	 * -------------------------------------------------------------->
	 */
//	회원찾기
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/auth/search")
	public String search(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
				   	     @RequestParam(name = "keyword", defaultValue = "!@#$%^&*()") String keyword,		// 키워드 기본값 특수문자로 초기 화면 없애기
				   	     @UserData ResMemberDetail detail, Model model) {
//		페이징 처리
		int pageSize = 10;
		int currentPage = pageNum;
		int start = (currentPage - 1) * pageSize + 1;
		int end = currentPage * pageSize;
		int count = 0;
		
		List<MemberDTO> list = memberService.search(detail.getMember_email(), keyword, start, end);
		for (MemberDTO memberDTO : list) {
			String statusB = "";
			String statusC = "";
			
			/* 친구 신청 상태 */
			if (friendService.friendRequestStatus(memberDTO.getMember_id(), detail.getMember_id()) != null) {
				statusB = friendService.friendRequestStatus(memberDTO.getMember_id(), detail.getMember_id());
			}else if (friendService.friendRequestStatus(detail.getMember_id(), memberDTO.getMember_id()) != null) {
				statusC = friendService.friendRequestStatus(detail.getMember_id(), memberDTO.getMember_id());
			}
			if (statusB.equals("S") && statusC.equals("S")) {
				memberDTO.setFriend_request_status("");
			}else if (statusB.equals("S")) {
				memberDTO.setFriend_request_status("S");
			}else if (statusC.equals("S")){
				memberDTO.setFriend_request_status("R");
			}
			
			/* 친구 상태 */
			if (friendService.friendStatus(detail.getMember_id(), memberDTO.getMember_id()) != null &&
				friendService.friendStatus(detail.getMember_id(), memberDTO.getMember_id()).equals("F")) {			// 내가 보낸 경우
				memberDTO.setFriend_request_status("F");
			}else if (friendService.friendStatus(memberDTO.getMember_id(), detail.getMember_id()) != null &&
					  friendService.friendStatus(memberDTO.getMember_id(), detail.getMember_id()).equals("F")) {	// 내가 받은 경우
				memberDTO.setFriend_request_status("F");
			}
		}
		
		if (list.size() > 0) {
			count = memberService.searchCount(detail.getMember_id(), keyword);
		}
		
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		int startPage = (int)((currentPage - 1) / 10) * 10 + 1;
		int pageBlock = 10;
		int endPage = startPage + pageBlock - 1;
		
		if (endPage >= pageCount) {
			endPage = pageCount;
		}
		
		if (keyword.length() < 3) {
			return "redirect:/member/auth/search";
		}
		
		model.addAttribute("count", count);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("pageNum", pageNum);
		
		model.addAttribute("keyword", keyword);					// 키워드
		
		model.addAttribute("list", list);						// 친구신청 리스트 (친구신청 상태 담겨있음)
		model.addAttribute("friendRoles", FriendRole.values());	// FriendRole 상태 권한설정
		
		model.addAttribute("status", detail.getMember_status());
		
		int receive_count = friendService.receiveRequestCount(detail.getMember_email());	// 받은 친구신청 수
		model.addAttribute("receive_count", receive_count);
		
		model.addAttribute("NAME", Masking.NAME);		// 타임리프로 마스킹 처리를 하기위해 넘겨줌
		
		model.addAttribute("detail", detail);
		
		return "member/member_search";
	}

}