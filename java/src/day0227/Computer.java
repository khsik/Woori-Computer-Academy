package day0227;
// 추상 클래스 - 추상 메서드를 가지는 클래스는 추상 클래스 뿐
public abstract class Computer {
	// 메서드
	public abstract void displaying();
	public abstract void typing();
	
	// 자손 클래스들이 공통으로 가질 메서드
	public void turnOn() {
		System.out.println("전원을 켭니다.");
	}
	public void turnOff() {
		System.out.println("전원을 끕니다.");
	}
}
