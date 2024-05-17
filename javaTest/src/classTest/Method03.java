package classTest;

class MobliePhone {
	String brand; // 브랜드
	double width; // 가로
	double length; // 세로
	double weight; // 무게
	
	void call (String phoneNum) {
		System.out.println(phoneNum + " 번호에 전화를 걸고 있습니다.");
	}
	void reciveCall () {
		System.out.println("전화받기");
	}
	void sendMessage() {
		System.out.println("문자보내기");
	}
	void reciveMessage() {
		System.out.println("문자받기");
	}
}

public class Method03 {
	public static void main(String[] args) {
		MobliePhone mp = new MobliePhone();
		mp.brand = "nokia";
		mp.width = 8.2;
		mp.length = 16.7;
		mp.weight = 193;
		System.out.println(mp.brand);
		System.out.println("가로: "+mp.width+"cm");
		System.out.println("세로: "+mp.length+"cm");
		System.out.println("무게: "+mp.weight+"g");
		mp.call("02-1111-2222");
	}
}
