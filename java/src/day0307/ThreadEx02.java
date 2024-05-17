package day0307;
/*
	join()
	- 스레드는 다른 스레드와 독립적으로 실행하는 것이 기본이지만
	 다른 스레드가 종료될 때까지 기다렸다가 실행해야하는 경우도 있음
*/
public class ThreadEx02 {
	public static void main(String[] args) {
		SumThread st = new SumThread();

		st.start();

		try {
			st.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("1부터 100까지의 합 = "+st.getSum());

	}
}
