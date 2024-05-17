package day0223;
/*
	다형성
	- 같은 타입이지만 실행 결과가 다양한 객체를 이용할 수 있는 성질
	- 하나의 타입에 여러 객체를 대입 -> 다양한 기능 이용 가능
	- 자바는 조상클래스로 타입변환 허용
		부모타입에 자식클래스가 대입 가능하다는 의미
*/

class A {}
class B extends A {}
class C extends A {}
class D extends B {}
class E extends C {}

public class PolymorphismEx01 {
	public static void main(String[] args) {
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();

		A a1 = b;
		A a2 = c;
		A a3 = d;
		A a4 = e;
		
		B b1 = d;
		C c1 = e;
		
//		상속 관계 아님. 다형성 불가능. 
//		B b2 = e;
//		C c2 = d;
	}
}
