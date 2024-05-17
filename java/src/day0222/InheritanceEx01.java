package day0222;
/*
	상속
	- 변수, 메서드 물려받음 (생성자는 메모리에 올라가지 않음)
	- 조상은 하나의 클래스만 가능, 1:1 상속
	- 자손의 객체를 생성하면 조상의 객체도 생성됨 (상속받음 = 조상의 주소를 참조)
*/
class A {
	int x = 10;
}

class B extends A {
	int y = 20;
}

class C extends A {
	int z = 30;
}

class D extends B {
	int i = 40;
}

public class InheritanceEx01 {
	public static void main(String[] args) {
		B b = new B();
		System.out.println(b.y);
		System.out.println(b.x);

		System.out.println();

		D d = new D(); // A, B, D 객체 생성됨.
//		D 객체 생성하려니까 -> 상속받고 있는 B 객체 생성하려니까 -> A 객체부터 생성
//		상속받은 클래스의 인스턴스 생성시에는 상속하는 부모 클래스 객체부터 생성
		System.out.println(d.i);
		System.out.println(d.y);
		System.out.println(d.x);

//		D d2 = new D();
//		System.out.println();
//		System.out.println(System.identityHashCode(b.x));
//		System.out.println(System.identityHashCode(b.y));
//		System.out.println(System.identityHashCode(d.x));
//		System.out.println(System.identityHashCode(d.y));
//		System.out.println(System.identityHashCode(d.i));
//		System.out.println(System.identityHashCode(d2.x));
//		System.out.println(System.identityHashCode(d2.y));
//		System.out.println(System.identityHashCode(d2.i));
	}
}
