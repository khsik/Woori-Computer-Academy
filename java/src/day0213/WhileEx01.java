package day0213;

class WhileEx01 {
	public static void main(String[] args) {
/*
		while문
		조건식이 true인 동안 실행문 반복 수행. = false일 때 반복하지 않음.

		while(조건식){	// true일 때
			실행문;		// 실행문 반복
		}
*/
		
		// 1~10까지 증가
		int i = 1;		//초기식
		while(i<=10){	//조건식
			System.out.print(i+" ");	//실행문
			i++;		//증감식
		}
	}
}
