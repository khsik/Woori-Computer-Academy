package day0208;

class OperEx11 {
	public static void main(String[] args) {
		// 복합 대입 연산자
		// 변수의 값이 바뀐다
		// = , += , -= , *= , /= , %=
		int a = 10;
		System.out.println(a+20);
		System.out.println(a);

		//대입연산자 사용
		System.out.println(a+=20);	// a = a+20
		System.out.println(a);		// 값 변함

		int b = 10;
		int c = ++b;		// 증가 대입
		System.out.println(b);
		System.out.println(c);
	}
}
