package com.example.ex;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter	// get()
@Setter	// set()
@NoArgsConstructor	// 기본생성자 (매개변수 없음)
@AllArgsConstructor	// 모든 매개변수가 있는 생성자
public class User {

	private String name;
	private int age;
}
