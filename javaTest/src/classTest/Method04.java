package classTest;

public class Method04 {
	static int sum(int a, int b) {
		return a>0 && b>0 ? a+b : 0;
	}
	
	static void gugudan(int dan){
		for(int i=1; i<10; i++) {
			System.out.printf("%dx%d="+(dan*i)+"\n",dan,i);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(sum(102, 83));
		System.out.println();
		gugudan(9);
	}
}
