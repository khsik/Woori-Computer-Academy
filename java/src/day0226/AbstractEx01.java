package day0226;
/*
	추상
	- 사전적 의미 : 실체들 간의 공통된 특성
		동물(개, 고양이, ...), 회사(LG, 삼성, ...)
		실체들의 공통적인 특성을 가지고 있는 추상적인것
	- 클래스에서도 추상 클래스 존재
	- 객체를 직접 생성할 수 있는 클래스 - 실체 클래스
	 이 클래스들의 공통적인 특성을 추출해서 선언한 클래스 - 추상 클래스
	- 추상 - 실체 (조상 - 자손)
	- 추가적인 특성을 가질 수 있다.
	
	- 추상 클래스는 new 를 이용해서 객체를 생성할 수 없다.
	- 상속을 통해서 자식객체를 만들어서 사용
	- 클래스들이 동일한 멤버(변수/메서드)를 가져야 할 때
	  추상 클래스로 만들어두면 편함

	추상 클래스 선언
	public abstract class 클래스이름{
		// 변수
		// 생성자
		// 메서드
	}
*/
public class AbstractEx01 {
	public static void main(String[] args) {
//		추상 클래스 객체 생성 불가
//		Phone phone = new Phone("name");
		
		SmartPhone smartPhone= new SmartPhone("java");

		// 자식 객체로 조상의 멤버(변수/메서드) 사용
		smartPhone.turnOn();
		smartPhone.internetSearch();
		smartPhone.turnOff();
	}
}
