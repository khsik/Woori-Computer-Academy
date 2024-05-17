package day0213;

class WhileEx05 {
	public static void main(String[] args) {
		int sum = 0;
		int i = 1;
		while(i<=100){
			sum += i;
			i++;
		}
		System.out.println("1~"+(i-1)+"까지의 합 = "+sum);
	}
}
