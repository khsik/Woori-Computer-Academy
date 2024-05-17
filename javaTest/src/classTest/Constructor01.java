package classTest;

class TinCase {
	double width; // 가로
	double length; // 세로
	double height; // 높이
	String color; // 색상
	
	void info() {
		System.out.println("가로: "+width+"cm");
		System.out.println("세로: "+length+"cm");
		System.out.println("높이: "+height+"cm");
		System.out.println("색상: "+color);
		System.out.println();
	}
	
	TinCase(double width, double length, double height, String color){
		this.width = width;
		this.length = length;
		this.height = height;
		this.color = color;
	}
}

public class Constructor01 {
	public static void main(String[] args) {
		TinCase tc1 = new TinCase(20, 15, 11.5, "빨간색");
		TinCase tc2 = new TinCase(33.3, 22.2, 11.1, "노란색");
		TinCase tc3 = new TinCase(20, 21, 20.5, "초록색");
		TinCase tc4 = new TinCase(17.5, 15, 13, "보라색");
		tc1.info();
		tc2.info();
		tc3.info();
		tc4.info();
	}
}
