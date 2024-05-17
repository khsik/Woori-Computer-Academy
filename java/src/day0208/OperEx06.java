package day0208;

class OperEx06 {
	public static void main(String[] args) {
		// 증감연산자의 위치 순서
		// 변수 앞(선증감) - 1순위
		// 변수 뒤(후증감) - 마지막 순위
/*
		i++ : 값을 참조한 후에 증가
		++i : 값을 참조하기 전에 증가
*/
		int a = 10;
		System.out.println(a++);	//출력10 연산11
		System.out.println(++a);	//연산12 출력12
		System.out.println(a++);	//출력12 연산13
		System.out.println(a++);	//출력13 연산14
		System.out.println(++a);	//연산15 출력15
		a++;						//연산16
		System.out.println(++a);	//연산17 출력17
		System.out.println(a);		//출력17

		System.out.println("------");

		//감소도 마찬가지
		int b = 10;
		System.out.println(b--);	//출력10 연산9
		System.out.println(--b);	//연산8 출력8
		System.out.println(b--);	//출력8 연산7
		System.out.println(b--);	//출력7 연산6
		System.out.println(--b);	//연산5 출력5
		b--;						//연산4
		System.out.println(--b);	//연산3 출력3
		System.out.println(b);		//출력3
	}
}
