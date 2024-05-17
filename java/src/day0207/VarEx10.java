package day0207;

class VarEx10 {
	public static void main(String[] args) {
		// 문자형 String
		// 기본 타입 아님
		String a;
		a = "hello";	// ""(큰따옴표) 사용
		System.out.println(a);

		String b;
		b = " ";		// 띄어쓰기, 공백 문자로 인식
		System.out.println(b);

		String c = "world";
		System.out.println(c);

		System.out.println(a+b+c);
	}
}
