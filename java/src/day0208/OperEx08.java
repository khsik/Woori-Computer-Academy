package day0208;

class OperEx08 {
	public static void main(String[] args) {
		// 비교 연산자  == , != , >, <, >=, <=
		// 비교연산자의 결과는 논리형으로 나온다.	true, false
		System.out.println(10 == 0);
		System.out.println(10 != 0);
		System.out.println(10 > 0);
		System.out.println(10 < 0);
		System.out.println(10 >= 0);
		System.out.println(10 <= 0);

		System.out.println("-------");

		// 변수를 사용하자
		int num1 = 5;
		int num2 = 3;
		boolean value = num1 > num2;
		System.out.println(value);

		value = num1 < num2;
		System.out.println(value);
	}
}
