package day0216;

public class PersonMain {
	public static void main(String[] args) {
		//객체 생성
		Person p1 = new Person();
		System.out.println("p1 변수가 Person 객체를 참조한다.");
		
		Person p2 = new Person();
		System.out.println("p2 변수가 Person 객체를 참조한다.");
		
		// 변수 p1, p2 스택 영역에 생성
		// 변수 p1, p2 두 객체는 각각의 주소를 참조하고 있다.
	}
}
