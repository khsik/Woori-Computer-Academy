package day0229;

public interface MyInterface {
	// 추상 메서드
	public void method1();
	
	// 기능 추가
/*	
	void method2();
		추상 메서드로 추가하면 하위 클래스에서 구현이 필수
		바로 하위 클래스에서 구현해서 적용하기 힘들 경우
		디폴트 메서드 사용
*/
	default void method2() {
		System.out.println("MyInterface method2() 실행");
	}
}
