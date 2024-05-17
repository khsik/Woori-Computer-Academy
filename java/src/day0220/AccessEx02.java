package day0220;

class ATest {
	public	static int a = 100;	// 모든 접근 허용
	private	static int b = 200;	// 같은 클래스만 허용
	public	static int c = b;	// 모든 접근 허용

	// 생성자
	private ATest () {}
}

public class AccessEx02 {
	public static void main(String[] args) {
		System.out.println(ATest.a);
//		System.out.println(ATest.b); // private 접근 못해서 오류
		System.out.println(ATest.c);
		
//		ATest at = new ATest(); // private 접근 못해서 오류
	}
}
