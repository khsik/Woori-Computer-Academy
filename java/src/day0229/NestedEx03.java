package day0229;

class AAA{
	class BBB{	// 인스턴스 클래스
		static final int z = 500; // 정적 변수는 상수만 가능
		int x = 100;
	}
}

public class NestedEx03 {
	public static void main(String[] args) {
//		AAA.BBB aabb = new AAA.BBB(); // 오류나옴
		AAA a = new AAA();
		AAA.BBB ab = a.new BBB(); // 중첩 인스턴스 클래스 객체 생성
		System.out.println(ab.x);
		System.out.println(AAA.BBB.z);
	}
}
