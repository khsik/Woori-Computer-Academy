package starTest;

public class StarTest10 {
	public static void main(String[] args) {
		int a,b;
		int c=5;
		for(a=1; a<=c; a++) {
			for(b=1; b<=c-a; b++) {
				System.out.print(" ");
			}
			for(b=1; b<=a*2-1 ;b++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
