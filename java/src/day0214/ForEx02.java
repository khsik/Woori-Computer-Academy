package day0214;

class ForEx02 {
	public static void main(String[] args) {
		// 1~100 출력
		for(int a=1; a<101; a++){
			System.out.println(a);
		}

		// 홀수
		int b;
		for(b = 1; b<=100; b+=2){
			System.out.println(b);
		}

		//짝수
		int c;
		for(c=2; c<101; c+=2){
			System.out.println(c);
		}

/*
		for(int d = 1; d<101; d++){
			if(d%2==0){System.out.print(d+" ");}	
		}
*/

	}
}
