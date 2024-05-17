package day0214;

class ForEx03 {
	public static void main(String[] args) {
		//1~100 합
		int sum=0, num;
		for(num=1; num<=100; num++){
			sum += num;
		}
		System.out.println(sum);

		//홀수 합
		int num2;
		int sum2 = 0;
		for(num2 = 1; num2<101; num2+=2){
			sum2 += num2;
		}
		System.out.println(sum2);

		//짝수 합
		int sum3 = 0;
		for(int num3=1; num3<=100; num3++){
			if(num3%2==0){sum3+=num3;}
		}
		System.out.println(sum3);
//		System.out.println(num3);	이러면 에러나옴. 선언된 영역 안에서만 사용 가능.
//									여기서 num3은 선언된 블록(for문) 내에서만 사용 가능한 지역변수
	}
}
