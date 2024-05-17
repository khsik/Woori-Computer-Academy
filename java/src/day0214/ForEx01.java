package day0214;

class ForEx01{
	public static void main(String[] args) {
/*
		for문
		가장 많이 사용하는 반복문. 배열과 주로 사용.
		반복문을 구현하는데 필요한 요소들을 함께 작성.
						한줄에 작성하기 때문에 간결, 가독성이 좋다.
		for(초기식; 조건식; 증감식){
			실행문;
		}

		초기식 - for문 시작 할 때 한번만 실행
		조건식 - 언제까지 반복할 것인지 구현
		증감식 - 증가/감소
		수행 순서가 중요함
		초기식-> 조건식-> 실행문-> 증감식-> 조건식-> 실행문-> 증감식-> 조건식-> ....-> 조건식false-> 종료
*/
		// 1~5까지 반복
		for(int i=1; i<=5; i++){
			System.out.println(i);
		}//for문 끝

		//"hello world" 5번 출력
		int a;
		for(a = 1; a<6; a++){
			System.out.println("hello world");
		}
/*
		int d = 1;
		for( ; ; d++){				//초기식 생략 가능하지만, 보통은 생략 안하고 사용함.
			System.out.println(d);	//조건식 생략하면 무한루프
		}
*/
	}
}
