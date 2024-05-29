package com.example.sbp.lamda;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Ex02 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("aaa", "bbb", "ccc");
		
		// Iterator 방식
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		// 또다른 List
		List<String> list2 = Arrays.asList("100", "200", "300");
		// Stream 방식
		Stream<String> stream = list2.stream();
		stream.forEach(ott -> System.out.println(ott));
	}
}
