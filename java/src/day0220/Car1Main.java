package day0220;

public class Car1Main {
	public static void main(String[] args) {
		// 객체 생성
		Car1 car = new Car1();
		// gas = 0 초기값
		
		car.setGas(5);
		// gas = 5
		
		if(car.isGas()) {
			System.out.println("출발");
			car.run();
		}
		System.out.println("가스를 넣어주세요.");
	}
}
