package com.example.ex.member;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberCreateForm {

	@Size(min = 4, max = 30, message = "아이디는 4글자 이상, 30글자 이하로 입력해 주세요.")
	@NotEmpty(message = "아이디는 필수 항목입니다")
	private String id;

	@Size(min = 6, max = 50, message = "비밀번호는 6글자 이상, 50글자 이하로 입력해 주세요.")
	@NotEmpty(message = "비밀번호는 필수 항목입니다")
	private String pw;
	
	@Size(min = 6, max = 50, message = "비밀번호는 6글자 이상, 50글자 이하로 입력해 주세요.")
	@NotEmpty(message = "비밀번호 확인은 필수 항목입니다")
	private String pw2;

	@Email
	@NotEmpty(message = "이메일은 필수 항목입니다")
	private String email;

	@NotEmpty(message = "성별은 필수 항목입니다")
	private String gender;

	@NotEmpty(message = "국가는 필수 항목입니다")
	private String country;

	@NotEmpty(message = "취미는 필수 항목입니다")
	private List<String> hobbies;
}
