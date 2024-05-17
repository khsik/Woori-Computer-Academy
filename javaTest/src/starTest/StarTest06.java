package starTest;

public class StarTest06 {
	public static void main(String[] args) {
		int a, b;
		int c=5;
		for(a=1; a<c; a++) {
			for(b=1; b<=a; b++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(; a>0; a--) {
			for(b=1; b<=a; b++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
