package justTest;

public class Test04 {
	public static void main(String[] args) {
		// 피보나치수열 n+1번째 수
		int n = 15;
		int[] arr = new int[n+2];
		arr[0] = 1;
		arr[1] = 1;
		for (int i=0; i<n; i++) {
			arr[i+2] = arr[i] + arr[i+1];
		}
		System.out.println(arr[n]);
	}
}
