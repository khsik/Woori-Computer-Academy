package day0228;
/*
	다중 인터페이스 구현 클래스
	- 객체는 다수의 인터페이스 타입으로 사용할 수 있다.
	- 모든 인터페이스의 추상 메서드를 구현해야 한다.
	
	public class 구현클래스 implements 인터페이스A, 인터페이스B, ... {
		// 인터페이스A의 추상 메서드 구현
		// 인터페이스B의 추상 메서드 구현
	}
 */
public class InterfaceEx03 {
	public static void main(String[] args) {
		SmartTelevision stv = new SmartTelevision();

		RemoteControl rc = stv;
		Searchable sa = stv;

		stv.turnOn();
		stv.setMute(true);
		stv.search("bing");
		stv.turnOff();
		System.out.println();

		rc.turnOn();
		rc.setMute(false);
		rc.setVolume(7);
		rc.turnOff();

		sa.search("google");
	}
}
