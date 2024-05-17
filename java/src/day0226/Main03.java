package day0226;
/*
	메서드 호출 - 보통 타입을 맞춰 호출
	매개값을 다양화 하기 위해 매개변수에 자식 객체를 지정할 수 있다.
*/
public class Main03 {
	public static void main(String[] args) {
		Driver driver = new Driver();
		
		Bus bus = new Bus();
		Taxi taxi = new Taxi();

		// .drive() 메서드는 매개변수 타입을 조상의 것(Vehicle)으로 선언
		// 자식객체 자동 타입 변환
		driver.drive(bus);
		driver.drive(taxi);
		// 메서드 호출시 자식 객체에서 오버라이딩 된 메서드 사용
	}
}
