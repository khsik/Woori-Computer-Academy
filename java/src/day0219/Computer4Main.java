package day0219;

public class Computer4Main {
	public static void main(String[] args) {
		// 객체 생성, 값 읽기, 값 변경, 변경한 값 읽기
		Computer4 c1 = new Computer4("검은색");
		Computer4 c2 = new Computer4("그램", "흰색");
		Computer4 c3 = new Computer4("갤럭시북", "네이비", 16);

		System.out.println(c1.color);
		System.out.println(c2.color + " " + c2.model);
		System.out.println(c3.inch + " " + c3.color + " " + c3.model);

		c1.color = "빨간색";
		c2.model = "비보북";
		c2.color = "실버";
		c3.inch = 14;
		c3.color = "흰색";
		c3.model = "맥북에어";

		System.out.println("c1 = " + c1.color);
		System.out.println("c2 = " + c2.model + " " + c2.color);
		System.out.println("c3 = " + c3.color + " " + c3.model + " " + c3.inch);
	}
}
