package apiTest;
/*
	2. 문자열(String) "Hello World" 와 "Java Programming!" 을 입력 받아, 해당 문자열을 
		문자 순서를 뒤집어서 char[]로 반환하는 메소드를 만들고,
		char[]을 입력 받아 출력하는 메소드를 만드시오. 
*/
public class Str02 {

	public static char[] toCharArr(String str) {
		StringBuilder sb = new StringBuilder(str);
		return sb.reverse().toString().toCharArray();
	}
	
	public static void printCharArr(char[] arr) {
		System.out.println(arr);
	}
	
	public static void main(String[] args) {
		String a = "Hello World";
		String b = "Java Programming!";
		printCharArr(toCharArr(a));
		printCharArr(toCharArr(b));
	}
}
