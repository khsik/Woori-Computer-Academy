package day0226;
/*
	instanceof 연산자
	- 어떤 객체가 어떤 클래스의 인스턴스인지 확인할 때 사용
	- instanceof 기준 왼쪽에 객체, 오른쪽에 타입이 온다.
		객체 instanceof 타입		true, false 리턴
	- 왼쪽의 객체가 오른쪽의 타입으로 생성 -> true / 아니면 false
	- 매개값의 타입 조사할 때 주로 사용

	- 메서드 내에서 강제 타입 변환이 필요한 경우,
		매개값이 어떤 객체인지 instanceof 연산자로 확인한 후
		안전하게 강제 타입 변환 해야한다.
	- ClassCastException 예외 발생
*/
public class Main05 {

	public static void method1(Parent3 parent3) {
		if(parent3 instanceof Child3) {
			Child3 child3 = (Child3)parent3;
			System.out.println("method1-Child3 변환 성공");
		}else {
			System.out.println("method1-Child3 변환 실패");
		}
	}

	public static void method2(Parent3 parent3) {
		Child3 child3 = (Child3) parent3;
		System.out.println("method2-Child3 변환 성공");
	}

	public static void main(String[] args) {
		Parent3 c1 = new Child3();
		Parent3 p1 = new Parent3();
		method1(p1);
		method1(c1);

		Parent3 c2 = new Child3();
		Parent3 p2 = new Parent3();
		method2(c2);
		method2(p2); // 예외 발생
		// 확인 없이 무조건 변환하려고 했기 때문
	}
}
