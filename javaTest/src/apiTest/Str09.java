package apiTest;
/*
	9. 각 자리수의 값을 더하여 출력하는 프로그램을 작성
	예) 4567 => 4+5+6+7 => 22를 출력하는 문제
*/
public class Str09 {
	public static int getSum(String str) {
		int sum = 0;
		for(int i=0; i<str.length(); i++) {
			sum += str.charAt(i) - '0';
		}
		return sum;
	}

	public static void main(String[] args) {
		// String 타입으로 숫자 주어진다고 가정
		String str = "4567";
		String str2 = "111123456789";

		System.out.println(getSum(str));
		System.out.println(getSum(str2));
	}
}
