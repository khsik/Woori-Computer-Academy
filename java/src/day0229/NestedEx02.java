package day0229;

class AA {
	static int num = 100;	// 정적 변수
	static void add() {		// 정적 메서드
		System.out.println("num = "+num);
	}
	static class BB{		// 정적 클래스
		static int x = 500;	// 정적 변수
		int y = 777;		// 인스턴스 변수
	}
}

public class NestedEx02 {
	public static void main(String[] args) {
		System.out.println(AA.num);		// 정적 - 객체생성 없이 사용
		AA.add();						// 정적 - 객체생성 없이 사용
		System.out.println(AA.BB.x);	// 정적 내부 클래스 속 정적 변수
										// AA BB 객체 생성 없이 사용 가능
		AA.BB b = new AA.BB();
		System.out.println(b.y);		// 내부 클래스의 인스턴스 멤버
	}
}
