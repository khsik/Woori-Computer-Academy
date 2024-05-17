package day0208;

class OperEx07 {
	public static void main(String[] args) {
		int a = 10, b = 10;
		System.out.println(++a + b);	//11 + 10 = 21

		int c = 10, d = 10;
		System.out.println(++c + ++d);	//11 + 11 = 22 

		int e = 10, f = 10;
		System.out.println(e++ + f++);	//10 + 10 = 20

		int g = 10;
		System.out.println(++g + ++g);	//11 + 12 = 23

		int h = 10;
		System.out.println(h++ + h++);	//10 + 11 = 21
		// h 변수 메모리에 연산자가 사용되어도 하나밖에 저장할 수 없다.
		// 선행 부분의 증감 연산 실행
	}
}
