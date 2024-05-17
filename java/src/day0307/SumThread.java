package day0307;
// ThreadEx02 에서 사용
public class SumThread extends Thread {
	private long sum; // 객체생성시 sum 기본값 0으로 초기화

	public void setSum(long sum) {
		this.sum = sum;
	}

	public boolean setSum(long[] numbers) {
		if(numbers.length == 0) {return false;}
		for(long number : numbers) {
			sum += number;
		}
		return true;
	}

	public long getSum() {
		return sum;
	}

	@Override
	public void run() {
		for(int i=1; i<=100; i++) {
			sum += i;
		}
	}
}
