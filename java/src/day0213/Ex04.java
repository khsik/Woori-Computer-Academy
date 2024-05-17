package day0213;

class Ex04 {
	public static void main(String[] args) {
		// ^ (xor연산자)
		// 같으면 0, 다르면 1
		int num1 = 5;	//0101
		int num2 = 10;	//1010
		int result1 = num1^num2; //1111
		System.out.println(result1);

		// ~ (반전 연산자)
		// 0 <-> 1 바꾸는 연산자
		int num3 = 10;
		int result2 = ~num3;
		System.out.println("~num3 = "+result2);
		//양수는 0에서부터지만 음수는 -1부터니까 절대값으로 1 차이난다?

		int a = 0b10000000000000000000000000000000;
		int b = 0b11111111111111111111111111111111;
		System.out.println(a);
		System.out.println(~a);
		System.out.println(b);
		System.out.println(~b);

		int c = 33;
		System.out.println(c);
		System.out.println(~c);
	}
}
