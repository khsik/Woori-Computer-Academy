package day0307;

class Thread01 implements Runnable {
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(Thread.currentThread().getName());
		}
		System.out.println("t1 종료");
	}
}

class Thread02 extends Thread {
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(getName());
		}
		System.out.println("t2 종료");
	}
}

// 메인 스레드 : 메인 메서드가 실행하면서 시작
public class ThreadEx01 {
	public static void main(String[] args) {
		Runnable t1r = new Thread01();	// 생성자에 들어갈 매개값 객체 생성
		Thread t1 = new Thread(t1r);	// 스레드 객체 생성

		Thread t2 = new Thread02();		// 일반적인 객체 생성과 동일

		t1.start();
		t2.start();

		System.out.println("main 종료");
	}
}
