package starTest;

public class StarTest08 {
	public static void main(String[] args) {
		int a,b;
		for(a=5; a>0; a--) {
			for(b=5-a;b>0;b--) {
				System.out.print(" ");
			}
			for(b=1; b<=a; b++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
