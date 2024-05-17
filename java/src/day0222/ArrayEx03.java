package day0222;

public class ArrayEx03 {
	public static void main(String[] args) {
		double[] dou = new double[5];

		// 0~2번 까지의 요소만 값 저장
		dou[0] = 10.0;
		dou[1] = 20.0;
		dou[2] = 30.0;

		// dou 배열의 전체 요소
		for(int i = 0; i<dou.length; i++) { 
			System.out.println(dou[i]);
		}
		
//		for(double d : dou) {
//			System.out.println(d);
//		}
	}
}
