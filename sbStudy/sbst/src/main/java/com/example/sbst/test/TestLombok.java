package com.example.sbst.test;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TestLombok {
	private String sss;
	private int iii;
	
	public static void main(String[] args) {
		TestLombok tl = new TestLombok();
		tl.setSss("test");
		tl.setIii(99);
		System.out.println(tl.getSss());
		System.out.println(tl.getIii());
	}
}
