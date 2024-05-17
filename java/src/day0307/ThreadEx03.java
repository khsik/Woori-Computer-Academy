package day0307;

class Thread_1 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print("-");
		}
	}
}

class Thread_2 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print("|");
		}
	}
}

public class ThreadEx03 {
	public static void main(String[] args) {
		Thread_1 th1 = new Thread_1();
		Thread_2 th2 = new Thread_2();

		th1.start();

//		try {
//			th1.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		th2.start();
	}
}
