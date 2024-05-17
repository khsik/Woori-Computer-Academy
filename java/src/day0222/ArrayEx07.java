package day0222;

public class ArrayEx07 {
	public static void main(String[] args) {
		// 다차원 배열
		// new int[][]
		int[][] arr = new int[2][3];
		arr[0][0] = 100;
		arr[1][2] = 600;

		int[][] xrr = {{1, 2, 3}, {4, 5, 6}};
		System.out.println(xrr[1][0]);
	}
}
