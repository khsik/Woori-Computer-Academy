package classTest;

class Bottle {
	String material; // 재질
	String color; // 색상
	String labelWords; // 라벨 문구
	double diameter; // 지름 
	double height; // 높이

	void info() {
		System.out.printf("재질: %s  /  색상: %s\n", material, color );
		System.out.printf("지름: %scm  /  높이: %scm\n", diameter, height);
//		System.out.println("라벨 문구: "+labelWords);
		System.out.println();
	}

	Bottle(String material){
		this(material, null, null, 0, 0);
	}
	Bottle(String material, String color){
		this(material, color, null, 0, 0);
	}
//	Bottle(String color, String labelWords){
//		this(null, color, labelWords, 0, 0);
//	}
	Bottle(double diameter, double height, String material){
		this(material, null, "", diameter, height);
	}
	Bottle(String material, String color, String labelWords, double diameter, double height){
		this.material = material;
		this.color = color;
		this.labelWords = labelWords;
		this.diameter = diameter;
		this.height = height;
	}
}

public class Constructor02 {
	public static void main(String[] args) {
		Bottle b1 = new Bottle(8, 20, "플라스틱");
		Bottle b2 = new Bottle(10, 30, "유리");
		Bottle b3 = new Bottle(6.5, 17, "스테인리스");

		b1.info();
		b2.info();
		b3.info();
	}
}
