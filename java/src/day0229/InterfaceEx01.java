package day0229;
/*
	디폴트 메서드 허용 이유
	- 기존 인터페이스를 확장해서 새로운 기능을 추가하기 위함
	- 기존 인터페이스 이름과 추상 메서드의 변경 없이 디폴트 메서드의 추가
		이미 구현된 객체 -> 수정 없이 그대로 사용 가능
		새로 구현할 객체 -> 추가된 기능 활용 가능
*/
public class InterfaceEx01 {
	public static void main(String[] args) {
		MyInterface m1 = new MyClassA();
		m1.method1(); // 구현 완료한 메서드
		m1.method2(); // 오버라이딩 안한 디폴트 메서드

		System.out.println();
		MyInterface m2 = new MyClassB();
		m2.method1(); // 구현 완료한 메서드
		m2.method2(); // 오버라이딩 한 디폴트 메서드
	}
}
