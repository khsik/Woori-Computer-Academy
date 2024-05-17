package day0213;

class Study0213 {
	public static void main(String[] args) {
/*		
		2진수, 8진수, 16진수
		비트 논리 연산자
		비트 이동 연산자
		if, else if, else
		switch
		while
*/
/*
		10진수	23
		2진수		0b10111
		8진수		027
		16진수	0x17
*/
/*
	비트 논리 연산자
		& (and) 양쪽 다 1이여야 1
		| (or) 둘중 하나라도 1이면 1
		^ (xor) 둘이 서로 달라야 1
		~ (반전) 0<->1

	비트 이동 연산자
		2진수에서 연산, 결과는 int타입으로 나온다.
		단, long타입으로 연산하면 결과도 long타입으로 나옴
		변수 << 값	변수의 비트를 왼쪽으로 값만큼 이동한다. 빈자리는 0으로 채운다.
		변수 >> 값	변수의 비트를 오른쪽으로 값만큼 이동한다. 부호비트는 유지하며, 빈자리는 0으로 채운다.
		변수 >>> 값	변수의 비트를 오른쪽으로 값만큼 이동한다. 부호비트를 유지하지 않으며, 빈자리는 0으로 채운다.

		int타입에 대입된 20을 2진수로 표현하면
		0b10100
		0b00000000000000000000000000010100
		여기서 0b 바로 뒤의 0이 부호비트다. 0이면 양수, 1이면 음수.
		0b11111111111111111111111111111111 == -1
		0b11111111111111111111111111101011 == ~20 == -21
*/
		System.out.println("비트 논리 연산자");
		int num1 = 11;	//0b1011
		int num2 = 13;	//0b1101
		System.out.println(num1&num2);	//0b1001
		System.out.println(num1|num2);	//0b1111
		System.out.println(num1^num2);	//0b0110
		System.out.println(~num1);

		System.out.println("비트 이동 연산자");
		byte a = 10;
		int b, c, d;
		b = a<<1;
		c = a>>1;
		d = -10;
		int d1 = d>>1;
		int d2 = d>>>1;
		System.out.println("10 << 1 = " + b);
		System.out.println("10 >> 1 = " + c);
		System.out.println("-10 >> 1 = " + d1);
		System.out.println("-10 >>> 1 = " + d2);
/*
	if, else if, else
		if(조건문){			조건문 결과가 true, false로 나와야함.
			실행문;			조건문 true일 때
		}else if(조건문){		이전의 조건문이 false일 때 다시 쓰는 조건문 else if(){}
			실행문;
		}else if(조건문){		else if는 여러번 쓸 수 있음.
			실행문;
		}else{				false일 때
			실행문;
		}					else if와 else는 선택적 사용. 필수아님. if없이는 쓸 수 없음.
*/

/*
	switch
		switch(변수){
			case 값1:		변수==값1 이면 해당 case의 코드블럭 실행
				실행문;
				break;		반복 취소. switch문을 끝냄. 이게 없으면 실행문 실행 이후에도 switch문 끝까지 진행
			case 값2:		break가 없으면 변수==값인 case가 있어도 끝까지 진행하는데, 이때 default가 있으면
				실행문;		default의 실행문이 실행되며 원치 않는 결과가 나올 수 있음.
				break;
			default:		선택적 사용. if문에서의 else와 비슷함. 위치가 꼭 마지막으로 고정된 것은 아님.
				실행문;
		}
*/
/*
				java 14버전 이상부터는 다음처럼 사용 가능함.
				case 값1, 값2, 값3, 값4.... :
					실행문;
					break;
				서로 다른 값이지만 같은 코드블럭을 사용할 때 편리함.
*/

/*
	while
		1~100까지의 합
		int sum = 0;
		int i = 1;
		while(i >= 100){	//조건문이 true일 동안 반복 실행. false면 종료.
			sum += i;		//실행문
			i++;			//증감식	이런게 없으면 조건식이 언제나 true인 문제가 생김.
		}
		System.out.println(sum);	//5050
*/

	}
}
