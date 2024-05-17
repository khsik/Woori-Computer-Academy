package day0229;
/*
	중첩 클래스
	- 클래스 내부에 선언한 클래스
	- 보통 클래스간의 관계를 맺을때 각각 독립적으로 선언
	- 특정 클래스하고만 관계를 맺을 때 클래스 내부에 선언하는 것이 좋다.

	기본 형태
	class ClassName{
		class NestedClass{	// 인터페이스도 가능...
			
		}
	}

	* 선언된 위치에 따라 두가지로 분류 *
	<멤버 클래스>
	- 인스턴스 멤버 클래스
		: 객체를 생성해야만 사용 가능한 중첩 클래스
	- 정적 멤버 클래스
		: 객체 생성 없이 중첩 가능한 클래스
	
	<지역 클래스>
		: 지역변수처럼 메서드 안에 위치
*/

class A {
	class B {}			// 인스턴스 클래스	- 객체 생성 후 사용
	static class C {}	// 정적 클래스		- 클래스명.클래스명		여기선 A.C
	void add() {
		class D {}		// 지역 클래스		- 해당 지역 내에서만 사용
	}
}

public class NestedEx01 {

}
