package day0222;

public class ArrayEx04 {
	public static void main(String[] args) {
		double[] dou = new double[5];
		
		// 값을 저장한 배열만 출력
		// for(int i=0; i<값을 저장한 요소의 개수; i++)
		int size = 0;
		
		dou[0] = 10.0;
		size++;
		dou[1] = 20.0;
		size++;
		dou[2] = 30.0;
		size++;
		
		for(int i=0; i<size; i++) {
			System.out.println(dou[i]);
		}
	}
}
