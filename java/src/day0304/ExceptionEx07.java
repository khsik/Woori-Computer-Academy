package day0304;
/*
	예외 떠넘기기
	- 경우에 따라서 메서드를 호출한 곳으로 예외를 떠넘길 수 있다.
	- 이때 사용하는 키워드 throws
	- 메서드 선언부 끝에 작성
		: 메서드에서 처리하지 않은 예외를 호출한 곳으로 떠넘기는 역할
	- throws Exception 만으로 모든 예외를 간단히 떠넘길 수 있다.

	리턴타입 메서드명(매개변수) throws ...Exception {}

	- 반드시 try-catch 블럭 내에서 호출되어야 함
		: catch 블럭에서 떠넘겨 받은 예외를 처리해야 한다.
*/
public class ExceptionEx07 {
	public static void main(String[] args) {
		try {
			thMethod(); // try 블럭 내에서 호출
		} catch (ClassNotFoundException e) {
			// 호출한 곳에서 예외 처리
			System.out.println("클래스가 존재하지 않습니다.");
		}
	}

	public static void thMethod() throws ClassNotFoundException {
		Class c = Class.forName("java.lang.String2");
	}
}
