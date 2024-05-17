package day0226;

public class Car {
	// 변수 : 4개의 타이어
	// Tire 생성자의 매개값 타이어의 위치, 최대 회전수
	Tire frontLeft = new Tire("앞 왼쪽", 6);
	Tire frontRight = new Tire("앞 오른쪽", 2);
	Tire backLeft = new Tire("뒤 왼쪽", 3);
	Tire backRight = new Tire("뒤 오른쪽", 4);
	
	// 메서드
	int run() {
		// roll() 타이어 1회전 시키는 메서드
		// 펑크 -> stop() 메서드 호출
		// 해당 타이어의 번호 리턴
		System.out.println("[자동차가 달립니다]");
		if(frontLeft.roll() == false) { stop(); return 1; }
		if(frontRight.roll() == false) { stop(); return 2; }
		if(backLeft.roll() == false) { stop(); return 3; }
		if(backRight.roll() == false) { stop(); return 4; }
		return 0;
	}
	
	public void stop() { // 펑크났을때
		System.out.println("[자동차가 멈춥니다]");
	}
}
