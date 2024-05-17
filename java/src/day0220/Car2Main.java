package day0220;

public class Car2Main {
	public static void main(String[] args) {
		Car2 car = new Car2();
		car.setSpeed(-50);
		System.out.println("현재 속도 : " + car.getSpeed());
		
		car.setSpeed(60);
		if(!car.isStop()) {
			car.setStop(true);
		}
		System.out.println("현재 속도 : " + car.getSpeed());
	}
}
