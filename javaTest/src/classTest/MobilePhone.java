package classTest;

public class MobilePhone {
	double width; // 변수1. 가로 사이즈 (실수. ex: 7.5cm)
	double length; // 변수2. 세로 사이즈 (실수)
	double thick; // 변수3. 두께 (실수)
	String color; // 변수4. 폰 색상
	String brand; // 변수5. 폰 브랜드 이름
	
	public static void main(String[] args) {
		MobilePhone mp = new MobilePhone();
		mp.width = 9.3;
		mp.length = 17.6;
		mp.thick = 8.7;
		mp.color = "cyan";
		mp.brand = "sky";
		System.out.println("가로: "+mp.width+"cm");
		System.out.println("세로: "+mp.length+"cm");
		System.out.println("두께: "+mp.thick+"mm");
		System.out.println("색상: "+mp.color);
		System.out.println("브랜드: "+mp.brand);
	}
}
