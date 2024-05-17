package day0220;

import java.util.*;
//import java.util.Date; java.util에 있는 Date 클래스만 추가
//import java.util.*; java.util에 있는 모든 클래스 추가.  * 가 전체를 의미

/*
	패키지
		클래스들의 묶음
		폴더
	임포트
		기술 아님. 편의를 위해 생겨남.
		java.lang 패키지를 제외한 다른 패키지의 클래스 객체 생성 시 사용
		* : 전체를 의미함
*/

public class ImportEx {
	public static void main(String[] args) {
		Date d = new Date();
//		java.util.Date d1 = new java.util.Date();
//		java.util.Date d2 = new java.util.Date();
//		java.util.Date d3 = new java.util.Date();
//		import 없이 쓰려면 매번 이렇게 길게 써야함
		int result = d.getDate(); // 취소선은 deprecated, 사용 권장하지 않음
		System.out.println(result);
	}
}
