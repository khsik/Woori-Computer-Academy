package day0223;
/*
	SportsCar의 조상 클래스
*/
public class Car {
	// 변수
	public int speed;
	
	// 메서드
	public void speedUp() {
		speed += 1;
	}
	
	// final 메서드
	public final void stop() {
		System.out.println("차를 멈춤.");
		speed = 0;
	}
}
