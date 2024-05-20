package com.example.sbp;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
// import lombok.Setter;

@RequiredArgsConstructor
@Getter
// @Setter
public class HelloLombok {
	private final String hello;
	private final int lombok;
	
	public static void main(String[] args) {
		// 변수 final 아니고 Getter, Setter만 있었을 때
		// HelloLombok hl = new HelloLombok();
		// hl.setHello("Hello");
		// hl.setLombok(100);
		
		HelloLombok hl = new HelloLombok("안녕", 200);
		
		System.out.println(hl.getHello());
		System.out.println(hl.getLombok());
	}
}
