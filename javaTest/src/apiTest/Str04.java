package apiTest;
/*
	4. arr 매개변수에서 문자열을 받아  '_'은 공백으로 , '/'은 ':'으로 변경한후
	리턴하는 프로그램을 구현하시오
		문자열 ==> "basic/java_web/jsp_framework/spring"
	
	[출력결과]
	basic:java  web:jsp  framework:spring
*/
public class Str04 {
	public static String change(String str) {
		return str.replace("_", " ").replace("/", ":");
	}
	
	public static void main(String[] args) {
		String a = "basic/java_web/jsp_framework/spring";
		System.out.println(change(a));
	}
}
