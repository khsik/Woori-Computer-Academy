package justTest;

public class Test03 {
	public static void main(String[] args) {
		String a = "1";
		System.out.println("a = "+a);
		System.out.println(System.identityHashCode(a));
		a +="2";
		System.out.println("a = "+a);
		System.out.println(System.identityHashCode(a));
		String b = "1";
		String c = "12";
		System.out.println("b = "+b);
		System.out.println(System.identityHashCode(b));
		System.out.println("c = "+c);
		System.out.println(System.identityHashCode(c));
		String d = "2";
		System.out.println("d = "+d);
		System.out.println(System.identityHashCode(d));
	}	
}
