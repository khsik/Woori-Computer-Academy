package day0222;
/*
	super()
	- 조상의 생성자 호출
	- 생성자 내에서만 사용
	- 첫줄에만 사용 가능 ( this()와 함께 사용 불가)

	오버라이딩
	- 선언부(매개변수 부분까지) 같고, 구현부 다르다
	- 접근제어자 수정 가능 (강하게(접근 범위가 좁아지게)는 불가능)

	어노테이션
	- @
	- 구별 쉽게 알려주는 역할
	- 생략 가능
	- 오버라이딩 @Override
*/
class AA {
	// 인스턴스 변수
	int x;

	// 생성자
	AA(){
		this(100);
	}

	AA(int x){
		this.x = x;
	}

	// 메서드
	public void aa() {
		System.out.println("조상의 메서드 AA");
	}
}

class BB extends AA {
	// 변수
	int y;

	// 생성자
	BB(){
//		x = 444;
		super(444);
		y = 500;
	}

	// 메서드
	// 선언부 (접근제어자) 리턴타입 메서드이름(매개변수)
	// 구현부 {}
	// 오버라이딩은 상속받은 클래스의 메서드를 다시 정의하는것. (선언부 같고, 구현부만 다른것)
	@Override
	public void aa() { // 오버라이딩 : 덮어쓰기
		System.out.println("자손이 수정한 BB");
	}

	public void aa(int i) { // 이름은같고 매개변수는 다른 오버로딩 (동명이인)
		
	}
}

public class InheritanceEx02 {
	public static void main(String[] args) {
		BB bb = new BB();
		System.out.println(bb.x);
		System.out.println(bb.y);
		bb.aa();
	}
}
