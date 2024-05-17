package day0213;

class WhileEx03 {
	public static void main(String[] args) {
		// 1~10의 합
		// 2개의 변수 필요  : 합이 될 변수, 반복할 변수
		int num = 1;
		int sum = 0;
		while(num<=10){
			sum+=num;
			num++;
		}
		System.out.println("1~10까지의 합 = "+sum);
	}
}
