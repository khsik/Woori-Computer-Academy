package day0220;

/*
	final (상수) 
	- 변경할 수 없는, 변경 불가의 의미
	- 클래스 앞에 붙으면 상속 못함.
	- 변수의 이름 대문자로 사용
*/

public class FinalEx01 {
	public static void main(String[] args) {
		// final 변수 사용할 때
		// 초기화 언제? - 선언과 동시에 or 사용 전에
		final int MAX_NUM = 100; // 선언과 동시에 초기화
		final int MIN_NUM;
		MIN_NUM = 0; // 선언과 동시에 안했을 뿐, 초기화임.
		
		System.out.println(MAX_NUM);
		System.out.println(MIN_NUM);
		
//		MIN_NUM = 1000; // 대입 불가능. 변경 불가
	}
}
