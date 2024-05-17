package day0223;
/*
	상속
	- 조상 클래스의 private 멤버(변수, 메서드) 상속 불가
	- 조상과 자손 클래스가 서로 다른 패키지에 존재한다면 default 멤버 상속 불가
	- 조상 클래스를 수정하면 자손 클래스들도 수정됨 - 유지/보수 최소화  
*/
public class InheritanceEx01 {
	public static void main(String[] args) {
		TvPhone tp = new TvPhone("java", "black", 10);

		// Phone 으로부터 상속 받은 변수
		System.out.println("모델 : " + tp.model);
		System.out.println("색상 : " + tp.color);

		// TvPhone 변수
		System.out.println("채널 : " + tp.channel);

		// Phone 에서 상속받은 메서드 호출
		tp.powerOn();
		tp.bell();
		tp.hangUp();
		tp.sendVoice("java");
		tp.receiveVoice("ruby");
		tp.powerOff();

		// TvPhone 메서드
		tp.turnOn();
		tp.changeChannel(7);
		tp.turnOff();
	}
}
