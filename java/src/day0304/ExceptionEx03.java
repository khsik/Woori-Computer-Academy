package day0304;
/*
	NumberFormatException
	- 문자열의 데이터를 숫자로 변경하는 경우 자주 발생
	- 문자열을 숫자로 변환하는 방법 여러가지 있음
		가장 많이 사용되는 코드로 확인
*/
public class ExceptionEx03 {
	public static void main(String[] args) {
		String data1 = "100";
//		String data2 = "a100";
		String data2 = "200";

		// Integer 클래스의 .parseInt(String s) 메서드 호출
		// 주어진 문자열을 정수로 변환 후 리턴
		int value1 = Integer.parseInt(data1);
		int value2 = Integer.parseInt(data2);
			// 예외 발생 : 숫자로 변환할 수 없는 문자 포함되어 발생.
			// data2 대입값 변경

		int result = value1 + value2;
		System.out.println(data1+" + "+data2+" = "+result);
//		System.out.printf("%d + %d = %d", value1, value2, result);
	}
}
