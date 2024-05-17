package day0219;

import day0220.AccessEx20;

public class AccessExMain extends AccessEx20 {
	public static void main(String[] args) {
		// 같은 패키지 내의 AccessEx 클래스 변수
		System.out.println(AccessEx.a); // public 모든 접근 허용
		System.out.println(AccessEx.b); // protected 같은 패키지, 혹은 상속 관계
		System.out.println(AccessEx.c); // default 같은 패키지
//		System.out.println(AccessEx.d); // private 본인 클래스 내에서만 사용

		// 다른 패키지의 AccessEx20 클래스 변수
		System.out.println(AccessEx20.a);
		System.out.println(AccessEx20.b);
//		System.out.println(AccessEx20.c);
//		System.out.println(AccessEx20.d);
	}
}
