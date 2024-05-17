package day0221;

public class TvMain {
	public static void main(String[] args) {
		// 객체 생성
		Tv t1 = new Tv();
		Tv t2 = new Tv("삼성", 65);
		
		t1.powerRev();
		t1.setChannel(3);
		int channel = t1.getChannel();
		System.out.println(channel);

		t1.channelUp();
		t1.channelUp();
		t1.channelUp(); // 6
		channel = t1.getChannel();
		System.out.println(channel);

		t1.channelDown();
		t1.channelDown(); // 4
		channel = t1.getChannel();
		System.out.println(channel);

		t1.view();
		t2.view();

		t1.powerRev();
		t1.view();
	}
}
