package day0216;

public class Car3Main {
	public static void main(String[] args) {
		// 객체 생성
		Car3 car1 = new Car3();
		System.out.println(car1.color);

		Car3 a = new Car3("현대");
		System.out.println(a.company);

		Car3 b = new Car3("흰색", "k5");
		System.out.println(b.model);
		System.out.println(b.color);

		Car3 c = new Car3("르노", "sm7", 250);
		System.out.println(c.company + " " + c.model);

		Car3 d = new Car3("볼보", "트럭", "그레이", 150);
		System.out.println(d.company + d.model + d.color + d.speed);

		// 값 변경
		// 변수이름 = 값;
		d.color = "파랑";
		System.out.println(d.color);
	}
}
