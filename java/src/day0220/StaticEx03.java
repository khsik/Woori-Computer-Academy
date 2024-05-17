package day0220;

class A {
	int x = 100;	// 인스턴스 기본형 변수
}

class B {
	int y = 200;	// 인스턴스 기본형 변수
	A a = new A();	// 인스턴스 참조형 변수
}

public class StaticEx03 {
	public static void main(String[] args) {
		B b = new B(); // 객체 생성

		System.out.println(b.y);
		System.out.println(b.a.x);
	}
}
