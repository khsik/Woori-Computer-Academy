package projectEuler;

//피보나치(Fibonacci) 수열의 각 항은 바로 앞의 항 두 개를 더한 것입니다.
//1과 2로 시작하는 경우 이 수열은 아래와 같습니다.
//1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
//4백만 이하의 짝수 값을 갖는 모든 피보나치 항을 더하면 얼마가 됩니까?
public class P2 { // 완료
	public static void main(String[] args) {
		int[] fibo = new int[100];
		fibo[0] = 1;
		fibo[1] = 2;
		
		int i = 1;
		while(fibo[i] <= 4000000) {
			i++;
			fibo[i] = fibo[i-2] + fibo[i-1];
		}

		int n = 0;
		int sum = 0;
		while(n <= i) {
			if(fibo[n]%2==0) {
				sum += fibo[n];
			}
			n++;
		}
		System.out.println(sum);
	}
}
