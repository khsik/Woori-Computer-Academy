package day0305;
/*
	String 클래스
	- 자바 문자열을 사용할 수 있도록 String 클래스 제공
	1) 문자열을 다양한 생성자로 이용하는 방식
	2) 코드상에서 리터럴 String 객체가 자동 생성되는 방식
*/
public class StringEx02 {
	public static void main(String[] args) {
		String str1 = new String("abc");
		String str2 = new String("abc");

		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));

		String str3 = "abc";
		String str4 = "abc";

		System.out.println(str3 == str4);
		System.out.println(str3.equals(str4));
	}
}
