package day0213;

class IfEx02 {
	public static void main(String[] args) {
/*
		if-else
		조건식을 만족하는 경우, 만족하지 않는 경우 모두 나타낼 때 사용한다.
		if(조건식){
			실행문1;	(조건식 true일 때)
		}else{
			실행문2;	(조건식 false일 때)
		}
*/

		int age = 2;
		if(age >=8){
			System.out.println("학교에 다닙니다.");
		}else{		//else는 필수가 아니고 선택
			System.out.println("학교에 다니지 않습니다.");
		}

	}
}
