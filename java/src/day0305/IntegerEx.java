package day0305;
/*
	- 정수 사용할 때 기본형인 int 사용
	- 정수를 객체로 사용해야 하는 경우
		: 자바에서는 기본 자료형처럼 사용할 수 있는 클래스 제공
		 이러한 클래스를 기본 자료형을 감쌋다 라는 의미로 Wrapper 클래스 라고 함.

	Wrapper 클래스
	Boolean, Byte, Character, Short, Integer, Long, Float, Double

	- 가장 대표적인 Integer 클래스 사용
		: int 자료형을 감싼 클래스
*/
public class IntegerEx {
	public static void main(String[] args) {
		Integer i = new Integer(100);

		// .intValue() : 클래스 내부의 int 자료형 값 리턴
		int iValue = i.intValue();
		System.out.println(iValue);

		// .valueOf() : static -> 생성없이 사용. Integer.valueOf();
		//				정수나 문자열 바로 Integer 클래스로 리턴
		Integer num1 = Integer.valueOf(200);
		Integer num2 = Integer.valueOf("300");
		System.out.println(num1);
		System.out.println(num2);

		// .parseInt() : 매개값으로 받은 문자열 -> int 로 리턴
		int num3 = Integer.parseInt("400");
		System.out.println(num3);
	}
}
