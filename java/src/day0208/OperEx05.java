package day0208;

class OperEx05 {
	public static void main(String[] args) {
		// 증감(증가 감소) 연산자
		// ++ , -- : 1 증가/감소
		// boolean 논리형 타입에서 사용 불가
		int a = 10;
		System.out.println(a);
		++a;		//;(세미콜론)이 붙어있으면 하나의 실행문
		System.out.println(a);
		a++;
		System.out.println(a);

		System.out.println("------");

		// 증감연산자의 위치에 따른 우선순위
		// 증감연산자가 변수의 뒤에 있을 때 연산이 제일 마지막에 일어난다 (앞에 있을 땐 제일 먼저)
		int b = 10;
		System.out.println(++b);	//선증가. 연산 후 출력
		System.out.println(b);		//출력
		System.out.println(b++);	//후증가. 출력 후 연산
		System.out.println(b);
	}
}
