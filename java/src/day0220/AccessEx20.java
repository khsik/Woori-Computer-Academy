package day0220;
// day0219 AccessEx, AccessExMain 참고

/*
	접근제어자
		모든 문법에서 가장 우선 적용
	- public	: 모든 접근 허용
	- protected	: 같은 패키지, 혹은 상속 관계
	- default	: 같은 패키지
				: 앞에 아무것도 없는 경우
	- private	: 해당(본인) 클래스 내에서만

	클래스		- public, default 만 사용 가능
	변수			- 모두 사용 가능	: 인스턴스, 정적 / 지역변수에는 사용 불가
	생성자/메서드	- 모두 사용 가능
*/

public class AccessEx20 {
	public		static int a;
	protected	static int b;
				static int c;
	private		static int d;
}
