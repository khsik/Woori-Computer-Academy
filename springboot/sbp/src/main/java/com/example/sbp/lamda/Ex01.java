package com.example.sbp.lamda;

@FunctionalInterface // 메서드 1개만 허용
interface Test1{
	// 매개변수 없는 추상메서드
	public abstract void name();
}

interface Test2{
	// 매개변수 하나인 추상메서드
	public abstract void name(String name);
}

interface Test3{
	// 매개변수 두개인 추상메서드
	public abstract void name(String name, int a);
}

interface Test4{
	// 정수 리턴하는 추상메서드
	public abstract int sum(int a, int b);
}

public class Ex01 {
	public static void main(String[] args) {
		
		// 익명클래스로 Test1 인터페이스 구현
		Test1 t = new Test1(){
			// name 메서드 구현
			public void name() {
				System.out.println("테스트1 익명클래스");
			}
		};
		t.name();
		
		// 람다식으로 Test1 인터페이스 구현
		Test1 t1 = () -> {
			System.out.println("테스트1 람다식");
		};
		t1.name();
		
		// 람다식으로 Test2 인터페이스 구현
		Test2 t2 = n -> {
			System.out.println(n);
		};
		t2.name("테스트2");
		
		// 람다식으로 Test3 인터페이스 구현 - 매개변수 타입이 다른 2개
		Test3 t3 = (s, n) -> {
			for(int i=0; i<n; i++) {
				System.out.println(s);
			}
		};
		t3.name("테스트3", 3);
		
		// 람다식으로 Test4 인터페이스 구현
		Test4 t4 = (a, b) -> {
			return a+b;
		};
		System.out.println(t4.sum(1, 3));
		
		// 람다식으로 Test4 인터페이스 구현2
		Test4 t4_2 = (a, b) -> a+b;
		System.out.println(t4_2.sum(11, 33));
	}
}

/*
	람다식 (익명 함수)
	(타입 매개변수) -> {실행문;}
	(int a) -> {System.out.println(a);}
	a -> System.out.println(a);
		변수가 하나-> 괄호, 타입 생략가능
		실행문 하나-> 중괄호 생략가능
	() -> {실행문;}
		매개변수 없음
	(x, y) -> {return x+y;}
	(x, y) -> x+y;
	
	인터페이스 사용시 메서드가 하나만 있어야 사용가능.
*/