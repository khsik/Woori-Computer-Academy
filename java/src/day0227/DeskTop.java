package day0227;

public class DeskTop extends Computer {

	// 상속 -> 추상메서드 추가 -> 오버라이딩 구현부 완성
	@Override
	public void displaying() {
		System.out.println("DeskTop displaying()");
	}

	@Override
	public void typing() {
		System.out.println("DeskTop typing()");
	}

}
