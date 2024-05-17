package day0219;

public class Computer4 {
	String company = "삼성";
	String model;
	String color;
	int inch;

	Computer4(String model, String color, int inch) {
		this.model = model;
		this.color = color;
		this.inch = inch;
	}
	Computer4(String model, String color){
		this(model, color, 0);	// 다른 생성자 호출
	}
	Computer4(String color){
		this(null, color, 0);
	}
}
