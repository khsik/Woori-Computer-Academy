package day0216;

public class Car3 {
	// 변수
	String company;
	String model;
	String color;
	int speed;

	// 생성자
	Car3(){}	// 생성자 선언 생략시 컴파일할 때 자동으로 추가되는 기본 생성자
	
	Car3(String company) {
		this.company = company;
	}

	Car3(String color, String model) {
		this.color = color;	
		this.model = model;
	}

	Car3(String c, String m, int s) {
		this.company = c;
		this.model = m;
		this.speed = s;
	}

	Car3(String company, String model, String color, int speed) {
		this.company = company;
		this.model = model;
		this.color = color;
		this.speed = speed;
	}
}
