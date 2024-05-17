package day0222;

public class ArrayEx01 {
	public static void main(String[] args) {
		// 배열 생성의 3가지 방법
		int[] arr1 = {2, 3, 5, 8, 13};

		// 배열이름[순서] - n개 개수 / 순서 n-1까지(0부터 시작)
		int[] arr2 = new int[5];
		arr2[0] = 10;
		arr2[1] = 11;
		arr2[2] = 12;
		arr2[3] = 13;
		arr2[4] = 14;

		int[] arr3;
		arr3 = new int[] {1, 2, 3, 4, 5};
		
		for(int i=0; i<arr1.length; i++) {
			System.out.println("arr1[" + i + "] = " + arr1[i]);
//			System.out.println(String.format("arr1[%s] = " + arr1[i], i));
//			System.out.printf("arr1[%d] = " + arr1[i] + "\n", i);
		}

		for(int ar3 : arr3) {
			System.out.println(ar3);
		}
	}
}
