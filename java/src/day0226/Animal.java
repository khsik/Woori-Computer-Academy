package day0226;
// 추상 클래스
public abstract class Animal {
	// 변수
	public String kind;
	
	// 메서드
	public void breathe() {
		System.out.println("숨을 쉽니다.");
	}
	
	// 추상 메서드 - {} 구현부 없다
	public abstract void sound();
}
