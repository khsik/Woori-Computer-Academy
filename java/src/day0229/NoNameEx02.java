package day0229;

abstract class No {
	public abstract void add();
}

class No2 extends No {
	@Override
	public void add() {
		System.out.println("Overriding");
	}
}

public class NoNameEx02{
//public class NoNameEx02 extends No {
//	@Override
//	public void add() {
//		System.out.println("Override at class");
//	}

	public static void main(String[] args) {
		No n1 = new No2(); // 다형성 - 조상타입 변수에 자손객체 대입 가능
		n1.add();

		No n2 = new No() {
			String nnn = "Yes: ";
			@Override
			public void add() {
				System.out.println(nnn+"Override in constructor");
			}
		};
		n2.add();
//		System.out.println(n2.nnn); // nnn 은 No 에 없어서 직접 사용 못함.

//		NoNameEx02 nn = new NoNameEx02();
//		nn.add();
	}
}
