package day0213;

class Ex02 {
	public static void main(String[] args) {
/*
		10진수 10

		1. 2진수로 바꿔준다
		2의 n제곱으로 표현
		128 64 32 16 8 4 2 1
		0   0  0  0  1 0 1 0
		2진수 0b1010

		2. 8진수 : 2진수로 바꾼 것에서 3자리씩 끊는다
		4 2 1  / 4 2 1 
		    1  / 0 1 0
		    1  /   2
		8진수 012

		3. 16진수 : 2진수로 바꾼 것에서 4자리씩 끊는다
		8 4 2 1 / 8 4 2 1
		        / 1 0 1 0
				/ A(10)
		16진수 0xA
*/
		int num = 10;
		int binary = 0b1010;
		int octal = 012;
		int hex = 0XA;

		System.out.println(num);
		System.out.println(binary);
		System.out.println(octal);
		System.out.println(hex);
	}
}
