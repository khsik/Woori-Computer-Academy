package starTest;

public class StarTest05 {
	public static void main(String[] args) {
		int a,b;
		for(a=5; a>0; a--) {
			for(b=a; b<a+5; b++) {
				System.out.print(b);
			}
			System.out.println();
		}
	}
}
