package day0220;

public class TestMain {
	public static void main(String[] args) {
		// 객체 생성
		Test tm = new Test();
		
		// x 값 읽기
		System.out.println(tm.x);
		
		// 각각의 메서드 호출
		tm.printX();
		tm.printY();
		tm.printXY();
		int result = tm.returnX();
		System.out.println(result);
	}
}
