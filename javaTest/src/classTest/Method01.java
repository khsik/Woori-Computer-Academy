package classTest;

class Ex01 {
	String str = "hello java";
	int year = 2020;

	void strOut() {
		System.out.println(str);
	}
	void yearOut() {
		System.out.println(year);
	}
} 

public class Method01 {
	public static void main(String[] args) {
		Ex01 ex01 = new Ex01();
		ex01.strOut();
		ex01.yearOut();
	}
}
