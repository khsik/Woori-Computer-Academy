package day0223;

class Aaa {
	String a;
	
	Aaa(){}
	Aaa(String a){
		this.a = a;
	}
	
	public void method() {
		System.out.println(a);
	}
}

class Bbb extends Aaa {
	int b;
	Bbb(){}
	Bbb(String a){
		super(a);
	}
}

class Ccc extends Bbb {
	int c;
	Ccc(){}
	Ccc(String a, int b, int c){
		super(a);
		super.b = b;
		this.c = c;
	}
	
	@Override
	public void method() {
		System.out.printf(a + "%d + %d\n", b, c);
	}
}

final class Ddd {
	public int d1;
	public int d2 = 10;
	public final int d3 = 20;
	
	public void dmethod() {
		System.out.println("method of final class Ddd");
	}
}

//class Eee extends Ddd {} 
//final class 를상속받을수 없음.

//final class Fff extends Aaa {}
//final class 여도 다른 (final이 아닌)클래스를 상속 받는건 가능함

public class Study {
	public static void main(String[] args) {
		Ddd d = new Ddd();
		d.dmethod();

		Ccc c = new Ccc();
		System.out.println(c.c);
		System.out.println(c.a);

		Ccc c2 = new Ccc("b + c = ",7 ,5);
		c2.method();

		System.out.println();
		Aaa a = new Aaa("aaaaa");
		a.method();
		a = c2;
		a.method();
		
		System.out.println();
		Bbb b = new Bbb("bbbbb");
		b.method();
	}
}
