package starTest;

public class StarTest09 {
	public static void main(String[] args) {
		int a,b;
		int c=6;
		for(a=1; a<c; a++) {
			for(b=1; b<=c-a; b++) {
				System.out.print(" ");
			}
			for(b=1;b<=a;b++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(; a>0; a--) {
			for(b=1; b<=c-a; b++) {
				System.out.print(" ");
			}
			for(b=1;b<=a;b++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
