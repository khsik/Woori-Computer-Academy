package day0214;

class ForEx07 {
	public static void main(String[] args) {
		// 반복문 <-> 조건문
		// 홀수 합, 짝수 합
		int num, odd = 0, even = 0;		//한번에 선언할 때 초기값 유무 확인
		for(num=1; num<=100; num++){
			if(num%2==1){		// 홀수 true   짝수 false
				odd += num;		// 홀수 합
			}else{
				even += num;	// 짝수 합
			}
		}
		System.out.println("홀수 합 = "+odd);
		System.out.println("짝수 합 = "+even);
	}
}
