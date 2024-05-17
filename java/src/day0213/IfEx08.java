package day0213;

class IfEx08 {
	public static void main(String[] args) {
		int score = 88;
		String result;
		if(score>=90){
			if(score>=95){
				result="A+";
			}else{
				result="A";
			}
		}else{
			if(score>=85){
				result="B+";
			}else{
				result="B";
			}
		}
		System.out.println("점수 : "+score);
		System.out.println("학점 : "+result);
	}
}
