package day0213;

class Ex05 {
	public static void main(String[] args) {
		//비트 이동 연산자(시프트 연산자)
		// << , >>
		// << 연산자 : 비트를 왼쪽으로 이동
		int num1 = 5;	//0b101
		int result1 = num1 << 2;	//0b10100
		System.out.println("num1 << 2 = " + result1);

		// >> 연산자 : 비트를 오른쪽으로 이동
		int num2 = 10;	//0b1010
		int result2 = num2 >> 2;	//0b0010  (오른쪽으로 두칸 이동)
		System.out.println("num2 >> 2 = " + result2);

		int num3 = 10;	//0b1010
		int result3 = num3<<3;	//0b1010000
		System.out.println("num3 << 3 = "+result3); //80

		int num4 = 5;	//0b101
		int result4 = num4>>1;	//0b10
		System.out.println("num4 >> 1 = "+result4); //2

		int num5 = 5;	//0b101
		int result5 = 5>>2;	//0b1
		System.out.println("num5 >> 2 = "+result5); //1

		// >>는 부호비트 유지하고 나머지 0으로 채우는데, >>>는 부호비트 유지 안함
		System.out.println("===============");
		System.out.println(-5>>1);
		System.out.println(-5>>>1);
		System.out.println(80<<25);
	}
}
