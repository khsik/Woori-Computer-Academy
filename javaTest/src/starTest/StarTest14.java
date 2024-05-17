package starTest;

public class StarTest14 {
	public static void main(String[] args) {
		int a,b;
		int c = 5;
		for(a=0; a<c; a++) {
			for(b=1; b<c-a; b++) {
				System.out.print(" ");
			}
			for(b=0; b<a*2+1; b++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(a-=1; a>0; a--) {
			for(b=0; b<c-a; b++) {
				System.out.print(" ");
			}
			for(b=0; b<a*2-1; b++) {
				System.out.print("*");
			}
			System.out.println();
		}
/*		
		for(a=1; a<=c; a++) {
			for(b=0; b<a; b++) {
				System.out.print(" ");
			}
			for(b=1; b<(2*c)-(2*a) ;b++) {
				System.out.print("*");
			}
			System.out.println();
		}
*/		
	}
}
