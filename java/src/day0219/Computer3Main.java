package day0219;

public class Computer3Main {
	public static void main(String[] args) {
		// 객체 생성
		Computer3 c1 = new Computer3("삼성");
		// 값 읽기
		System.out.println(c1.company);
		
		// 객체 생성 시 매개변수 순서 지켜줘야 한다
		Computer3 c2 = new Computer3("gram", "흰색");
		System.out.println(c2.model + " " +c2.color+"\n");
		
		Computer3 c3 = new Computer3("삼성", "갤럭시북", "검은색");
		System.out.println(c3.company);
		System.out.println(c3.model);
		System.out.println(c3.color+"\n");
		
		Computer3 c4 = new Computer3("애플", "맥북에어", "흰색", 15);
		System.out.println(c4.company);
		System.out.println(c4.color+" "+c4.model);
		System.out.println(c4.inch);
	}
}
