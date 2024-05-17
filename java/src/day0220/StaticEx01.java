package day0220;

/*
	정적(static) 멤버
	- 정적 변수 / 정적 메서드
	- 메모리에 올라오는 순서가 다름
	- 프로그램이 시작됨과 동시에 메모리에 올라간다(사용준비 완료)
		상주 메모리
	- 객체 생성 없이 사용 가능
*/

class Data {
	static int a = 10;
	int b = 1;

//	int c = 10;
//	static int d = c;	// 오류 나옴. 메모리에 올라가는 순서 문제
	//	int c는 객체가 생성되야 메모리에 올라가는데 int d는 바로 올라가있음
	//	존재하지 않는 상태의 c를 대입할 수 없음.

	static void add() {
		System.out.println("a = " + a);
	}
	void bbb() {
		System.out.println("bbb() 실행");
	}
}

public class StaticEx01 {
	public static void main(String[] args) {
		System.out.println(Data.a);
		Data.add();
		
		

//		Data d = new Data();
//		System.out.println(d.a);	// 이렇게도 사용 가능 하지만 이렇게 사용 안함
//		System.out.println(d.b);
//		
//		d.add();	// 이렇게도 사용 가능 하지만 이렇게 사용 안함
//		d.bbb();
	}
}
