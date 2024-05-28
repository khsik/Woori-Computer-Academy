package com.example.sbst.board;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardForm {

	private String writer;

	@Size(min = 6, max = 150, message = "dd")
	private String title;
	
	@NotEmpty(message = "내용을 입력해주세요.")
	private String content;
	
}
