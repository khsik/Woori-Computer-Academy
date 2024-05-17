package day0227;
// 조상
public abstract class Car {
	// 추상 메서드 - 자손 클래스들 따라 구현부 다름
	public abstract void drive();
	public abstract void stop();

	// (구현된) 메서드 - 자손 클래스들이 공통으로 사용할 메서드
	public void startCar() {
		System.out.println("시동을 겁니다.");
	}
	public void turnOff() {
		System.out.println("시동을 끕니다.");
	}
	
	final public void run() {
		startCar();
		drive();
		stop();
		turnOff();
	}
}
