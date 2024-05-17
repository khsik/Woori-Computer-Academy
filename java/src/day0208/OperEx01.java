package day0208;

class OperEx01 {
	public static void main(String[] args) {
		// 부호 연산자 ( + , - )
		int num1 = 10;
		int num2 = 20;
		System.out.println(+num1);
		System.out.println(-num2);	//-가 대입된건 아님.
		System.out.println(num2);

		num2 = -num2;	//대입을 해야 값이 바뀐다.
		System.out.println(num2);
	}
}
