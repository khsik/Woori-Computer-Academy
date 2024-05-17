package day0304;
/*
	Object 클래스
	- 자바의 최고 조상 클래스
	- extends 키워드로 다른 클래스를 상속하고 있지 않다면
		java.lang.Object 클래스를 상속하고 있다.
	- 변수 없이 메서드만 가지고 있다.
	- 이 메서드들은 모든 클래스가 상속받기 때문에 사용 가능

	.equals()
	- 두 인스턴스의 주소값을 비교하여 true/false 결과 리턴
		: 물리적 동일성( 인스턴스의 메모리 주소가 같음 )
	- 서로 다른 주소값을 가지지만 같은 인스턴스라고 정의할 때
		: 논리적 동일성( 논리적으로 두 인스턴스가 같음 )
		: 객체가 저장하고 있는 데이터의 값이 동일한 경우
	
	기준객체.equals(비교객체)
	
*/
public class ObjectEx01 {
	public static void main(String[] args) {
		Member obj1 = new Member("blue");
		Member obj2 = new Member("blue");
		Member obj3 = new Member("red");

		if(obj1.equals(obj2)) { // 매개값이 Member 타입이고 id 변수값이 동일 true
			System.out.println("obj1과 obj2가 동일합니다.");
		}else {
			System.out.println("obj1과 obj2가 동일하지 않습니다.");
		}
		
		if(obj1.equals(obj3)) { // 매개값이 Member 타입이지만 id 변수값이 다름 false
			System.out.println("obj1과 obj3이 동일합니다.");
		}else {
			System.out.println("obj1과 obj3이 동일하지 않습니다.");
		}
	}
}
