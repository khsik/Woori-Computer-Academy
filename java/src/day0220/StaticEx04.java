package day0220;

class Tv {
	static String company = "SAMSUNG";
	static String model = "QLED";
	static String info;

	static {
		info = model + " " + company;
	}
	static void isInfo() {
		System.out.println(model + " " + company);
	}
}

public class StaticEx04 {
	public static void main(String[] args) {
		System.out.println(Tv.info);
		Tv.isInfo();
		
		System.out.println();
		Tv.company = "LG";
		Tv.model = "miniLED";
		System.out.println(Tv.info);
		Tv.isInfo();
	}
}
