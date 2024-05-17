package day0222;
/*
	super. / super()
	- 조상의 것을 의미

	super.
	- 조상의 변수 사용
	- 자손의 변수와 이름이 같을 때 사용
*/

class AAA {
	int x = 100;
}

class BBB extends AAA {
	int y = 111;
	int x = 222; // BBB 클래스의 x

	public void bb() {
		int x = 50;
		System.out.println(x); // 메서드 내부의 지역변수
		System.out.println(this.x); // 객체 자신
		System.out.println(super.x); // 조상
	}
}

public class InheritanceEx03 {
	public static void main(String[] args) {
		BBB bbb = new BBB();
		bbb.bb();
	}
}
