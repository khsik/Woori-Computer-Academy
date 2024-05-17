package day0213;

class WhileEx04 {
	public static void main(String[] args) {
		// 1~100 합
		int i = 1;
		int sum = 0;
		while(i<=100){
			sum+=i;
			i++;
		}
		System.out.println(sum);

		// 홀수 합
		int odd = 1;
		int sumOdd=0;
		while(odd<=100){
			sumOdd+=odd;
			odd+=2;
		}
		System.out.println(sumOdd);

		// 짝수 합
		int even = 2;
		int sumEven=0;
		while(even<=100){
			sumEven+=even;
			even+=2;
		}
		System.out.println(sumEven);

	}
}
