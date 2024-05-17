package day0306;

public class StringBuilderEx02 {
	public static void main(String[] args) {
		// StringBuilder 객체 생성
		StringBuilder sb = new StringBuilder();
		
		// .append(...) : 문자열 끝에 매개값 추가
		sb.append("Java ");
		sb.append("Program ");
		sb.append("Study");
		System.out.println(sb.toString());
		
		// .insert(index, 매개값) : index 에 매개값 삽입
		sb.insert(4, "2");
		System.out.println(sb);
		
		// .setCharAt(index, '값') : index 에 있는 문자 '값'으로 변경
		sb.setCharAt(4, '6');
		System.out.println(sb.toString());
		
		// .replace(int 시작(포함), int 끝(포함 안함), String str) : 시작부터 끝까지 str 로 대체
		sb.replace(6, 13, "Book");
		System.out.println(sb);
		
		// .delete(시작, 끝) : 시작(이상)부터 끝(미만)까지 삭제
		sb.delete(4, 5);
		System.out.println(sb.toString());
		
		// .length() : 문자열의 길이
		int len = sb.length();
		System.out.println("문자열의 길이 : "+len);
		
		// buffer 에 있는 것을 String 타입으로 리턴
		String result = sb.toString();
		System.out.println(result);
	}
}
