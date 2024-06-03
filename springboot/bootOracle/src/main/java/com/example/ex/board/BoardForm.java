package com.example.ex.board;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardForm {

	@NotEmpty
	@Size(max = 255)
	private String title;
	
	@NotEmpty
	@Size(max = 4000)
	private String content;
}
