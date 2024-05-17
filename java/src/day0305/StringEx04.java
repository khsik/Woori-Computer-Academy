package day0305;

public class StringEx04 {
	public static void main(String[] args) {
		String s1 = "hello world";
		String s2 = " 　hello world ";
		String s3 = "HELLO WORLD";
		System.out.println(s1.charAt(0));		// 0번째의 문자 리턴
		System.out.println(s1.indexOf('w'));	// 문자의 위치 리턴
		System.out.println(s1.indexOf('k'));	// 해당 문자가 없을때 -1 리턴
		System.out.println(s1.lastIndexOf('l'));// 마지막에 오는 해당 문자의 위치 
		System.out.println(s1.replace("h", "a"));// (왼, 오) 왼쪽을 오른쪽으로 변환
		System.out.println(s1.replaceAll("hello", "aaa")); // 문자열 바꿔서 리턴
		System.out.println(s1.toUpperCase());	// 소문자 -> 대문자
		System.out.println(s3.toLowerCase());	// 대문자 -> 소문자
		System.out.println(s1.substring(6));	// index 6번부터 끝까지 자른것을 리턴
		System.out.println(s1.substring(6,9));	// index 6이상 9미만 잘라서 리턴
		System.out.println(s1.length());		// 문자열 길이(, 개수, 크기) 리턴
		System.out.println(s2.trim());			// 유니코드 \u0020 이하의 공백 제거 (space, tab)
		System.out.println(s2.strip());			// 유니코드 모든 공백 제거

		String s4 = "java html css jsp spring";
		String[] ss = s4.split(" ");
		int num = 0;
		for(String s : ss) {
			System.out.printf("%d. %s ", ++num, s);
		}
		System.out.println();

		for(int i=0; i<ss.length; i++) {
			System.out.println(ss[i]);
		}
	}
}
