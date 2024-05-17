package day0229;
/*
	익명 구현 객체
	- 구현클래스 만들어서 객체로 사용
		클래스 재사용 할 수 있어서 편리
	- 일회성의 구현객체가 필요할 때
		클래스 만들고 생성하는 것이 비효율적
	- 익명구현객체 생성하여 인터페이스 변수에 대입하여 사용
		이때, 하나의 실행문이므로 끝에 ; 붙여야 한다.
	
	 인터페이스 변수 = new 인터페이스 (){
	 	// 인터페이스에 선언된 추상 메서드 모두 구현
	 	
	 	// 추가적 변수, 메서드 익명객체 안에서만 사용 가능
	 	// 인터페이스 변수로 사용 불가능
	 };
*/
public class NoNameEx01 {
	public static void main(String[] args) {
		RemoteControl rc = new RemoteControl() {
			@Override
			public void turnOn() {
				System.out.println("On");
			}
			@Override
			public void turnOff() {
				System.out.println("Off");
			}
			@Override
			public void setVolume(int volume) {
				System.out.println(volume);
			}
		};
		rc.turnOn();
		rc.setVolume(6);
		rc.turnOff();
	}
}
