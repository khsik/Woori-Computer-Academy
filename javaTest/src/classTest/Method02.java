package classTest;

class Ex02{
	int a;
	boolean isPlay = false;
	double d;

	void setA(int a) {
		this.a = a;
	}
	void setPlay() {
		isPlay = !isPlay;
	}
	void setD() {
		d = Math.PI;
	}
}

public class Method02 {
	public static void main(String[] args) {
		Ex02 ex = new Ex02();
		ex.setA(2024);
		ex.setPlay();
		ex.setD();
		System.out.println(ex.a);
		System.out.println(ex.isPlay);
		System.out.println(ex.d);
	}
}
