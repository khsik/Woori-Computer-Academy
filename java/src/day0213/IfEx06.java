package day0213;

class IfEx06 {
	public static void main(String[] args) {
		// 점수에 따라 등급이 나오는 코드
		// int score, char grade
		// 90, 80, 70, 60 / A B C D F
		// 결과 B 나오게 구성

		int score = 86;
		char grade;
		if(score>=90){
			grade='A';
		}else if(score>=80){
			grade='B';
		}else if(score>=70){
			grade='C';
		}else if(score>=60){
			grade='D';
		}else{
			grade='F';
		}
		System.out.println(grade);

	}
}
