package day0220;

class TvSchool {
	// 정적 인스턴스 변수
	static boolean power;
	static int channel;

				// 스태틱 블록 : 정적 멤버 초기화 하는 블럭
	static {	// 생성자의 역할과 비슷하다. 한 클래스에 여러개 넣을 수 있다.
		power = true;
		channel = 10;
	}
}

public class StaticEx02 {
	public static void main(String[] args) {
		System.out.println(TvSchool.power);
		System.out.println(TvSchool.channel);
	}
}
