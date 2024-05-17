package day0213;

class WhileEx02 {
	public static void main(String[] args) {
		// 1~100까지 출력
		int i = 1;
		while(i<=100){
			System.out.println(i);
			i++;
		}

		// 1~100 홀수 출력
		int odd = 1;
		while(odd<=100){
			System.out.println(odd);
			odd+=2;
		}

		// 1~100 짝수 출력
		int even=1;
		while(even<=100){
			if(even%2==0){System.out.println(even);}
			even++;
		}

/*
		System.out.println("==============================");
		int a=1;
		while(a<10){
			System.out.print(a+"  ");
			a++;
		}
		while(a<=100){
			System.out.print(a+" ");
			if(a%10==0){System.out.println();}
			a++;
		}
*/
	}
}
