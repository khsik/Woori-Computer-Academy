package day0223;
/*
	Car 의 자손 클래스
*/
public class SportsCar extends Car {
	@Override
	public void speedUp() {
		speed += 2;
	}

//	@Override
//	public final void stop() {
//		System.out.println("스포츠카를 멈춤.");
//		speed = 0;
//	}
}
