package day0214;

class ContinueEx01 {
	public static void main(String[] args) {
/*
		continue문
		반복문 안에서 continue;를 만나면 이후의 코드 실행하지 않고 반복문 다시 수행
		for문: 증감식으로 이동
		while문: 조건식으로 이동
		반복문 수행 중 특정 조건에서는 수행하지 않고 건너뛰어야 할 때 사용.
*/
		int a;
		for(a=1; a<=3; a++){
			if(a==3){
				continue;
			}
			System.out.println(a);
		}
		System.out.println("======");

		// 1~100 짝수 출력
		int b;
		for(b=1; b<=100; b++){
			if(b%2==1){
				continue;
			}
			System.out.println(b);
		}
		System.out.println("======");

		//1~100 홀수의 합
		int sum=0;
		for(int i=1; i<=100; i++){		//1~100 반복
			if(i%2==0){		// 짝수면 true
				continue;	// 이후 코드 진행 안하고 증감식으로
			}
			sum+=i;			// 홀수만 +=
		}
		System.out.println("1~100 홀수의 합 = "+sum);
	}
}
