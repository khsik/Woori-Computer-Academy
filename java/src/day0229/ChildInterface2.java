package day0229;

public interface ChildInterface2 extends ParentInterface {
	// Parent 의 default 메서드 오버라이딩
	public default void method2() {
		System.out.println("Child2 default Override");
	}

	// Child2 자신의 추상 메서드 추가
	public void method3();
}
