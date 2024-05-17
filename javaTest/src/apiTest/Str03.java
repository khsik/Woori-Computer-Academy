package apiTest;
/*
	3. 매개변수로 받은 문자열에서 각 단어의 첫 번째만 리턴하는 make 메서드를 구현하시오. 
		문자열 ==> "Java Data Base Connectivity"	=> 출력 "JDBC"
		문자열 ==> "Java Server Pages"			=> 출력 "JSP"
		문자열 ==> "Enterprise Java Beans"		=> 출력 "EJB"
*/
public class Str03 {

	public static String iniset(String str) {
		StringBuilder sb = new StringBuilder();
		sb.append(str.charAt(0));
		for(int i=1; i<str.length(); i++) {
			if(str.charAt(i-1) == ' ') {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String a = "Java Data Base Connectivity";
		String b = "Java Server Pages";
		String c = "Enterprise Java Beans";
		System.out.println(iniset(a));
		System.out.println(iniset(b));
		System.out.println(iniset(c));
	}
}
