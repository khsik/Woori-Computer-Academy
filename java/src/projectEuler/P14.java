package projectEuler;
/*
양의 정수 n에 대하여, 다음과 같은 계산 과정을 반복하기로 합니다.

n → n / 2 (n이 짝수일 때)
n → 3 n + 1 (n이 홀수일 때)

13에 대하여 위의 규칙을 적용해보면 아래처럼 10번의 과정을 통해 1이 됩니다.

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
아직 증명은 되지 않았지만, 이런 과정을 거치면 어떤 수로 시작해도 마지막에는 1로 끝나리라 생각됩니다.
(역주: 이것은 콜라츠 추측 Collatz Conjecture이라고 하며, 이런 수들을 우박수 hailstone sequence라 부르기도 합니다)

그러면, 백만(1,000,000) 이하의 수로 시작했을 때 1까지 도달하는데 가장 긴 과정을 거치는 수는 얼마입니까?

참고: 계산 과정에는 백만을 넘어가는 수가 나와도 괜찮습니다.
*/
public class P14 { // 완료.	10만은 되는데 100만이 안됨 -> num 타입을 int 대신 long 으로 쓰니까 해결
	public static void main(String[] args) {
		int maxProcess = 0;
		long maxProcessNum = 0;

		for(int i=1; i<=1000000; i++) {
			int process = 0;
			long num = i;
			while(num!=1) {
				if(num%2==0) {
					num = num/2;
					process++;
				}else {
					num = (3*num) + 1;
					process++;
				}
			}
			if(maxProcess<process) {
				maxProcess = process;
				maxProcessNum = i;
			}
		}
		System.out.println("가장 오래 걸리는 과정은 "+ maxProcess + "번의 과정이며");
		System.out.println("그때의 숫자는 "+ maxProcessNum + "입니다.");
	}
}
