package day0305;
/*
	.clone()
	- 원본 객체를 복사(복제)
	- 동일한 값을 가지는 새로운 객체 생성
		: 원본 객체를 보호할 때 사용
	- 반드시 원본 객체에 java.lang.Cloneable 인터페이스 구현해야 함
		: 하지 않으면 예외 발생 -> 예외 처리 필수
*/
public class ObjectEx04 {
	public static void main(String[] args) {
		// 원본 객체 생성
		Member origin = new Member("java", "jsp", "12345", 10, true);

		// 객체 복제
		Member clone = origin.getMember();
		clone.pw = "67890";
		
		System.out.println("[원본 객체의 값]");
		System.out.println("name : "+origin.name);
		System.out.println("id : "+origin.id);
		System.out.println("pw : "+origin.pw);
		System.out.println("age : "+origin.age);
		System.out.println("adult : "+origin.adult);

		System.out.println();
		
		System.out.println("[복제 객체의 값]");
		System.out.println("name : "+clone.name);
		System.out.println("id : "+clone.id);
		System.out.println("pw : "+clone.pw);
		System.out.println("age : "+clone.age);
		System.out.println("adult : "+clone.adult);
	}
}
