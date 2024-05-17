package day0305;
/*
	hashCode()
	- 참조변수를 출력할 때 본 16진수의 숫자 값 : 해시코드 값
		: 힙 메모리에 저장된 객체의 주소 값
	- 두 객체가 같다면 hashCode() 메서드에서 해시코드 값이 같아야 한다.
		: .equals 메서드를 재정의(오버라이딩) 했다면
		  .hashCode() 메서드도 재정의 필요하다.
 */
public class ObjectEx03 {
	public static void main(String[] args) {
		String str1 = new String("abc");
		String str2 = new String("abc");

		// .hashCode()
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());

		// 같은 문자열을 가진 경우
		// .equals() 메서드의 결과가 true 인 경우
		// .hashCode() 메서드도 동일한 해시코드 값 리턴

		Integer i1 = new Integer(100);
		Integer i2 = new Integer(100);
		
		System.out.println(i1.hashCode());
		System.out.println(i2.hashCode());
		// 같은 정수를 가진 경우
		// .equals() 메서드의 결과가 true 인 경우
		// .hashCode() 메서드도 동일한 해시코드 값 리턴
	}
}
