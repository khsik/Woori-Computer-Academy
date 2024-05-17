package day0226;
/*
	강제 타입 변환 ()		(int),...
	- 부모타입을 자식타입으로 변환하는 것.
	- 모든 부모타입을 자식타입으로 강제변환 할 수 있는것은 아니다.
	- 자식타입이 부모타입으로 자동 타입 변환된 후에
		다시 자식 타입으로 변환할 때 강제타입변환 사용
	
	- 자식 -> 부모 : 자동변환
		부모타입에 산언된 변수와 메서드만 사용 가능하다는 제약
	- 자식타입의 변수와 메서드를 사용해야 한다면
	- 자식타입으로 변환(강제 타입변환) 후에 자식의 변수/메서드 사용하면 됨
		
*/
public class Main04 {
	public static void main(String[] args) {
		Parent2 parent2 = new Child2();
		parent2.var1 = "data1";
		parent2.method1();
		parent2.method2();

//		자식 객체만의 변수, 메서드
//		parent2.var2 = "data2"; // 오류
//		parent2.method3(); // 오류

		// 강제 타입 변환
		// 자식 객체로 변환
		Child2 child2 = (Child2)parent2;
		child2.var2 = "aaa";
		child2.method3();

		System.out.println(child2.var1);
	}
}
