package day0229;

public interface ChildInterface3 extends ParentInterface {
	// parent 의 default 메서드를 추상 메서드로 재선언(오버라이딩)
	@Override
	public void method2();

	// Child3 추상 메서드
	public void method3();
}
