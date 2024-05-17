package day0219;

public class Computer3 {
	// 클래스 변수 - 속성
	// 제조사 모델 색상 크기
	String company;
	String model;
	String color;
	int inch;

	// 생성자
	// 클래스(매개변수, ...){}
//	Computer3(String c){
//		company = c;
//	}
	// 주로 매개변수의 이름은 클래스 변수 이름과 같게 사용

	Computer3(String company) {
		this.company = company;
	}

	Computer3(String model, String color) {
		this.model = model;
		this.color = color;
	}

	Computer3(String company, String model, String color){
		this.company = company;
		this.model = model;
		this.color = color;
	}
	
	Computer3(String company, String model, String color, int inch){
		this.company = company;
		this.color = color;
		this.model = model;
		this.inch = inch;
	}
}
