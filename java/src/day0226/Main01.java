package day0226;

public class Main01 {
	public static void main(String[] args) {
		Child child = new Child();
		Parent parent = child; // 자동 타입 변환
		parent.method1();
		parent.method2(); // 오버라이딩된 메서드 호출
//		parent.method3(); 호출 불가능. 자식클래스의 멤버.
		child.method3();
		System.out.println(child);
		System.out.println(parent);
	}
}
