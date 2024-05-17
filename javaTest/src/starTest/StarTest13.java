package starTest;

public class StarTest13 {
	public static void main(String[] args) {
		int a,b;
		for(a=5; a>1; a--) {
			for(b=0; b<5-a; b++) {
				System.out.print(" ");
			}
			for(b=0; b<a; b++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(a=0; a<5; a++) {
			for(b=1; b<5-a; b++) {
				System.out.print(" ");
			}
			for(b=0; b<=a; b++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
