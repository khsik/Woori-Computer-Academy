package day0229;

class N {
	void add() {	// 메서드
		class M {		// 지역 클래스
			int x = 100;
		}
		M m = new M();	// 해당 지역 내에서만 사용 가능. 
						// 메서드 내부에서 생성하고 사용해야 한다.
		System.out.println(m.x);
	}
}

public class NestedEx04 {
	public static void main(String[] args) {
		N n = new N();
		n.add();
	}
}
