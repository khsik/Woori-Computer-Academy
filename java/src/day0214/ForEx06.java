package day0214;

class ForEx06 {
	public static void main(String[] args) {
		// 반복문 속 조건문 <-> 조건문 속 반복문
		for(int a=1; a<=10; a++){
			// for문 true
			if(a%2==0){
				System.out.println(a+" = 짝수");
			}else{
				System.out.println(a+" = 홀수");
			}// if문 끝
		}// for문 끝
	}
}
