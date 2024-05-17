package day0304;
/*
	예외 Exception
	- 자바에서는 에러 외의 오류로는 예외가 있다.
	- 예외가 발생하면 프로그램 곧바로 종료된다. (에러와 동일)
	- 예외 처리를 통해 프로그램을 종료하지 않고 정상 실행상태 유지

	모든 예외클래스는
	java.lang.Exception
	클래스를 상속받는다.
	
	1) 일반 예외
	: 코드 작성 실수로 발생함.
	: 컴파일러 체크 예외 라고도 함.
	
	2) 실행 예외
	: 예외 처리 필수 아님.
	: 경험에 의해 예외처리 코드 삽입 필요.
	: 모든 예외 알 수 없다. -> 자주 발생하는 실행 예외 알아둬야함.

	NullPointerException
	- 가장 빈번하게 발생
	- 객체 참조가 없는 상태
	- 참조변수. -> 객체가 없는데 객체를 사용하려고 하면 발생하는 예외
*/
public class ExceptionEx01 {
	public static void main(String[] args) {
		String data = null; // String 객체 참조하고 있지 않음.
		System.out.println(data.toString());
		// toString() : String 객체가 가지고 있는 메서드
	}
}
