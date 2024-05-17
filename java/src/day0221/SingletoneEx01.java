package day0221;
/*
	싱글톤 패턴
	- 인스턴스를 단 하나만 생성하는 디자인 패턴
	- 프레임워크에서 다시 사용해 볼 것임.
*/
/*	메모리 올라가는 순서대로 변수끼리, 메서드끼리 정렬하는게 좋음.
	아래에서도 적용하면
	private static School instanse = new School();
	private School(){}
	
	public static School getInstanse() { .... }
*/
class School {
	private School(){}	// 컴파일러가 추가하는 기본생성자 public
						// 외부 클래스에서 인스턴스를 여러개 생성 가능
						// private : 클래스 내부에서만 생성자 사용 가능
	private static School instanse = new School();
		// School 타입의 변수 instanse 에 기본 생성자로 객체 생성
		// 사용할 인스턴스 한개는 필요해서 클래스 내부에서 하나의 인스턴스 생성
	public static School getInstanse() {
		if(instanse == null) { // 참조변수는 참조하고 있는것이 없으면 null
			instanse = new School();
		}
		return instanse;	// 유일하게 생성된 인스턴스(객체) 반환
	} // static 없으면 메서드 사용하기 위해 객체를 생성해야 하는데
	  // 외부에서의 객체 생성을 private 로 막아뒀음.
	  // 참조변수 instanse 역시 비슷한 맥락.
}

public class SingletoneEx01 {
	public static void main(String[] args) {
		// static 클래스 이름으로 호출.
		// 참조변수로 받는다.
		School s1 = School.getInstanse();
		School s2 = School.getInstanse();

		// 유일한 인스턴스인지 확인 (같은 주소인지 확인)
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1 == s2);
	}
}
