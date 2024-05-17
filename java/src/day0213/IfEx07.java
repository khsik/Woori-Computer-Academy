package day0213;

class IfEx07 {
	public static void main(String[] args) {
		// 중첩 if문
		int score = 97;
/*		String grade;	초기화 안하면 오류나옴
			컴파일 하기전에 검사 하고 컴파일.
			grade는 if문 안에서만 대입이 되는데 조건식이 true일 때만 대입됨.
			컴파일, 실행 해보기 전에는 grade에 값이 대입된다고 보장할 수 없어서 오류나옴.
*/
		String grade="";
		if(score>=90){
			if(score>=95){
				grade = "A+";
			}else{
				grade = "A";
			}
		}
		System.out.println(grade);
	}
}
