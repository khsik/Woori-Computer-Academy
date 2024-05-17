package day0229;

public class PClass implements PInterface {

	@Override
	public void x() { // X 인터페이스에서 상속받은 메서드
		System.out.println("x() 실행");
	}

	@Override
	public void y() { // Y 인터페이스에서 상속받은 메서드
		System.out.println("y() 실행");
	}

	@Override
	public void pMethod() { // PInterface 메서드
		System.out.println("pMethod() 실행");
	}

}
