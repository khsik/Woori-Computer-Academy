package com.example.ex.member;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberPwForm {
	@Size(min = 6, max = 50, message = "비밀번호는 6글자 이상, 50글자 이하로 입력해 주세요.")
	@NotEmpty(message = "비밀번호는 필수 항목입니다")
	private String pw;
	
	@Size(min = 6, max = 50, message = "비밀번호는 6글자 이상, 50글자 이하로 입력해 주세요.")
	@NotEmpty(message = "비밀번호 확인은 필수 항목입니다")
	private String pw2;
}
