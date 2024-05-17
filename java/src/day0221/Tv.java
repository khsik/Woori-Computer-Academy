package day0221;
/*
	setChannel(int channel) - 채널 입력 받음 (조건 - 0~10 값만 대입 가능)
	channelUp() - 채널 1 증가 (조건 - 현재 10인 경우 0으로 변경)
	channelDown() - 채널 1 감소 (조건 - 현재 0인 경우 10으로 변경)
	view() - 모든 변수 값 출력
*/
// 변수, 메서드에 각각 주석으로 설명을 달아야 좋음.
// 나중에 다시 보거나, 다른 사람이 봐도 빨리 알 수 있음.
public class Tv {
	// 인스턴스 변수
	public final String BRAND;	// 브랜드  final 이라 변경 불가능해서
	public final int SIZE;		// 사이즈  public 사용
	private int channel;		// 채널	0~10
	private boolean power;		// 전원	T-on F-off

	Tv() {
		this("LG", 80);
	}

	Tv(String b, int s) {
		BRAND = b;
		SIZE = s;
		channel = 0;
		power = false;
	}

	// 메서드
	// 리턴타입 메서드이름() {}
	public void powerRev() {
		power = !power;
	}

	public void setChannel(int channel) {
		if(channel >= 0 && channel <= 10) {
			this.channel = channel;
		}
	}

	public int getChannel() {
		return channel;
	}

	public void channelUp() {
		channel++;
		if(channel == 11) {
			channel = 0;
		}
	}

	public void channelDown() {
		if(channel == 0) {
			channel = 10;
		}else {
			channel--;
		}
	}

	public void view() {
		System.out.println("\n"+"BRAND : " + BRAND);
		System.out.println("SIZE : " + SIZE);
		System.out.println("channel : " + channel);
		System.out.println("power : " + power);
	}
}
