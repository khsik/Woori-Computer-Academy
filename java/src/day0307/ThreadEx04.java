package day0307;
/*
	sleep()
	- 실행중인 스레드를 일정시간 멈추게 함
	
*/

class Thread001 extends Thread {
	public void run() {
		for(int j=0; j<3; j++) {
			for(int i=0; i<100; i++) {
				System.out.print("-");
			}
			System.out.println("\nth1 1초 대기");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("\n[th1 종료]");
	}
}

class Thread002 extends Thread {
	@Override
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.print("|");
		}
		System.out.println("\n[th2 종료]");
	}
}

public class ThreadEx04 {
	public static void main(String[] args) {
		Thread001 th1 = new Thread001();
		Thread002 th2 = new Thread002();
		
		th1.start();
		th2.start();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("<<main 종료>>");
	}
}
