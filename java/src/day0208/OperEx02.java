package day0208;

class OperEx02 {
	public static void main(String[] args) {
		// 산술 연산자 ( + - * / % )
		int a = 10;
		double d = 10.5;
		System.out.println(a+d);
		
		int b = 10;
		double c = 5.5;
		//double result = b + c;
		int result = (int)(b + c);	//b + (int)c 해도 됨.
		System.out.println(result);
		
		int num1 = 10;
		int value;
		value = num1 + 10;
		num1 = value;
		System.out.println(num1);
		System.out.println(value);
		
	}
}
