package day0219;

public class Calculator {
	// 메서드
	// 리턴타입 메서드이름(매개변수,...){구현부}
	int plus(int x, int y) { 
		return x + y;
	}

	double divide(int x, int y) {
		double result = (double) x / (double) y;
		return result;
	}

	int minus(int x, int y) {
		return x - y;
	}

	int multi(int x, int y) {
		int result = x * y;
		return result;
	}

	// 리턴 타입이 없는 메서드
	void powerOn() {
		System.out.println("전원을 켭니다.");
	}

	void powerOff() {
		System.out.println("전원을 끕니다.");
	}
}
