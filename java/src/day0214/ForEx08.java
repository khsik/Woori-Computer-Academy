package day0214;

class ForEx08 {
	public static void main(String[] args) {
		// 1~n까지의 합이 100이상이 될 때, n 구하기
		int sum = 0;
		int num = 0;
		for(num=0; sum<100; num++){
			sum += num;
		}
		System.out.println("num : "+num);	//15
		// 증감식으로 1 증가한 이후 조건식에서 false가 나와서 반복 종료.
		// 위에서 num이 15가 나오지만, 실제 합이 100을 넘었을 때의 num은 14
		System.out.println("sum : "+sum);
		// 105가 대입된 이후에 조건식에서 false가 나온 것임. sum=105
	}
}
