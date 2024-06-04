package com.example.ex.member;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberModifyForm {

	@NotEmpty(message = "비밀번호를 입력해주세요.")
	private String pw;
	
	@Size(max = 50, message = "비밀번호는 6글자 이상, 50글자 이하로 입력해 주세요.")
	private String npw;
	
	@Size(max = 50, message = "비밀번호는 6글자 이상, 50글자 이하로 입력해 주세요.")
	private String npw2;
	
	@Email
	@NotEmpty(message = "이메일은 필수 항목입니다")
	private String email;
	
	private List<String> hobbies;
}
