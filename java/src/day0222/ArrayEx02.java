package day0222;

public class ArrayEx02 {
	public static void main(String[] args) {
		int[] scores = { 70, 85, 87, 90 };

		// 총 합 구하기
		int sum = 0;
		for(int i=0; i<scores.length; i++) {
			sum += scores[i];
		}
		System.out.println("총 합 : " + sum);

		System.out.println();

		// 향상된 for문 사용
		// for(변수선언 : 반복대상) {}
		for(int score : scores) {
			System.out.println(score);
		}
		
		int sum2 = 0;
		for(int score : scores) {
			sum2 += score;
		}
		System.out.println("합계 : " + sum2);
	}
}
