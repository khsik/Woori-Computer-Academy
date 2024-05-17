package day0227;
// Car 자손 클래스 2
public class PersonCar extends Car {
	@Override
	public void drive() {
		System.out.println("사람이 운전합니다.");
		System.out.println("사람이 방향을 바꿉니다.");
	}
	
	@Override
	public void stop() {
		System.out.println("사람이 브레이크를 밟고 정지합니다.");
	}
}
