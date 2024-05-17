package day0213;

class Ex03 {
	public static void main(String[] args) {
		// 비트 연산자
		// 비트값을 기반으로 하는 연산자
		// 비트단위로 연산 이루어짐
		// 비트 논리 연산자 ( & , | , ^ , ~ )
		// & (and연산자) - 2개의 비트값이 모두 1인 경우에만 연산의 결과 값이 1
		int num1 = 5;	//0101
		int num2 = 10;	//1010
		int result1 = num1 & num2;	//0000
		System.out.println(result1);//0

		// | (or연산자) - 비트 값이 하나라도 1이면 결과 값이 1이다
		int num3 = 5;	//0101
		int num4 = 10;	//1010
		int result2 = num3|num4;	//1111
		System.out.println(result2);//15

		int num5 = 5;	//101
		int num6 = 7;	//111
		int result3 = num5&num6;	//101
		System.out.println(result3);//5

		int num7 = 10;	//1010
		int num8 = 7;	//0111
		int result4 = num7|num8;	//1111
		System.out.println(result4);//15

	}
}
