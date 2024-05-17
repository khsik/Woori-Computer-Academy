package day0305;

public class ObjectEx02_2 {
	public static void main(String[] args) {
		String str1 = new String("abc");
		String str2 = new String("abc");

		System.out.println(str1 == str2);
				// 두 객체의 주소가 다름
		
		System.out.println(str1.equals(str2));
				// String 클래스에서 재정의(오버라이딩)
				// 두 객체가 가진 문자열이 같은지 비교

		Integer i1 = new Integer(100);
		Integer i2 = new Integer(100);

		System.out.println(i1==i2);
		System.out.println(i1.equals(i2));
				// 오버라이딩 : 두 객체의 정수값 같은지 비교
		
	}
}
