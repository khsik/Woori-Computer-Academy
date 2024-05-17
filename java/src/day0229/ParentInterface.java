package day0229;

public interface ParentInterface {
	// 추상 메서드
	public void method1();

	// 디폴트 메서드
	public default void method2() {
		System.out.println("Parent default() 실행");
	}
}
