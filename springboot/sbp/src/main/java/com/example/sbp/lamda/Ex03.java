package com.example.sbp.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex03 {
	public static void main(String[] args) {
		// 리스트 생성
		List<String> list = Arrays.asList("java", "jsp", "html", "css", "spring");
		
		// 스트림 생성
		Stream<String> st = list.stream();

		// 중복 요소 제거
		st = st.distinct();
		
		// 반복으로 출력
		st.forEach(n -> System.out.println(n));
		
		System.out.println(new String("==").repeat(10));
		
		list.stream()
			.distinct()
			.forEach(n -> System.out.println(n));
		
		System.out.println(new String("--").repeat(10));
		
		list.stream()
			.filter(n -> n.startsWith("j"))
			.forEach(n -> System.out.println(n));
		
	}
}
