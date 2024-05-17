package starTest;

public class StarTest12 {
	public static void main(String[] args) {
		int a,b;
		int c=5;
		for(a=c; a>0; a--) {
			for(b=a; b>0; b--) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(a=2; a<=c; a++) {
			for(b=0; b<a; b++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
