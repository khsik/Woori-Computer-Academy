package justTest;

public class Test01 {
	public static void main(String[] args) {
		String a = "aaa";
		String b = "aaa";
		
		String c = new String("aaa");
		String d = new String("aaa");
		
		System.out.println(a==b);	//T
		System.out.println(a==c);	//F
		System.out.println(a.equals(c));	//T
		System.out.println(c==d);	//F
		System.out.println(c.equals(d));	//T
		
		String[] arr = {"aaa", "bbb", "ccc", "ddd"};
		System.out.println(arr[2]);		
	}
}
