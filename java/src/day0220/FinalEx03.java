package day0220;

class Fin {
	final int X = 100;
	final static int Y = 500; // static final 이렇게 바뀌어도 괜찮음.
	final int Z;

	Fin(int Z) {
		this.Z = Z;
	}
}

public class FinalEx03 {
	public static void main(String[] args) {
		int a = 10;
		System.out.println(a);
		a = 99;
		System.out.println(a);

		System.out.println(Fin.Y);
//		Fin.Y = 600; // final 변경 불가

//		final int b = 10;
//		b = 20;
//		b++;
//		b += 1;
		
//		System.out.println("=======");		
//		Fin f = new Fin(777);
//		System.out.println(f.X);
//		System.out.println(f.Y);
//		System.out.println(System.identityHashCode(f.Y));
//		System.out.println(Fin.Y);
//		System.out.println(System.identityHashCode(Fin.Y));
//		System.out.println(f.Z);
	}
}
