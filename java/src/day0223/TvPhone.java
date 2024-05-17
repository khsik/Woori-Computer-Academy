package day0223;
/*
	Phone의 자손 클래스
	InheritanceEx01에서 실행
*/
public class TvPhone extends Phone {
	// 변수
	int channel;
	
	// 생성자
	TvPhone(String model, String color, int channel){
		this.model = model;
		this.color = color;
		this.channel = channel;
	}

	// 메서드
	void turnOn() {
		System.out.println("채널 "+ channel +"번 시청을 시작합니다.");
	}
	void changeChannel(int channel) {
		this.channel = channel;
		System.out.println("채널을 "+channel+"번으로 바꿉니다.");
	}
	void turnOff() {
		System.out.println("Tv 시청을 멈춥니다.");
	}
}
