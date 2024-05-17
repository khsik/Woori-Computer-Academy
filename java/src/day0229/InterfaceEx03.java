package day0229;

/*
	인터페이스 상속
	- 인터페이스 간에도 상속 가능
	- 구현 코드를 통해 기능을 상속하는 것이 아님
		형 상속(type inheritance)이라고 부름
	- 클래스 상속은 하나만 받을 수 있지만,
		인터페이스는 여러개 동시에 상속받을 수 있음
	- 상속받는 인터페이스는 상위 인터페이스들의 모든 추상 메서드를 가지게 된다
		해당 인터페이스를 구현하는 클래스는 모든 추상 메서드 구현해야 한다
*/
public class InterfaceEx03 {
	public static void main(String[] args) {
		PClass pc = new PClass();

		// 상위 인터페이스
		X x = pc;
		x.x(); // X 인터페이스에 선언한 메서드만 사용 가능

		System.out.println();

		Y y = pc;
		y.y(); // Y 인터페이스에 선언한 메서드만 사용 가능

		System.out.println();

		// 구현한 인터페이스 타입의 변수에 대입
		// 인터페이스가 상속한 모든 메서드 호출 가능
		PInterface pi = pc;
		pi.x();
		pi.y();
		pi.pMethod();
	}
}
