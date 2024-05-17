package day0305;
/*
	java.lang.StringBuilder, StringBuffer 클래스
	- 문자열을 변경하거나 연결해야할 때 사용
	- String str = "hello";
			 str += " world";
				"hello world"
	: 한개의 String 객체가 사용되었다고 생각하지만
	  사실 새로운 String 객체가 생성됨.
	  그리고 str 변수는 새로운 객체를 참조함.

	- 공통점 : 두 클래스는 내부 버퍼(buffer : 데이터 임시저장 메모리)에
			 문자열을 저장해두고 그 안에서 추가, 수정, 삭제 가능
			 두 클래스 사용 방법 동일
	- 차이점 : 여러 작업(스레드)이 동시에 문자열을 변경하려고 할 때
			 문자열이 안전하게 변경되도록 보장해 주는가 아닌가 차이
	- StringBuffer : 안전하게 보장(멀티스레드 환경에서 사용 가능하도록 동기화 적용되어 있음)
*/
public class StringBuilderEx {
	public static void main(String[] args) {
		String str = new String("Java");
		System.out.println("str 문자열 주소 : "+Integer.toHexString(System.identityHashCode(str)));

		// StringBuilder 생성
		StringBuilder sb = new StringBuilder(str);
		System.out.println("추가 전 sb 주소 : "+Integer.toHexString(System.identityHashCode(sb)));
		
		// .append() : 문자열 추가
		sb.append(" Programming");
		sb.append(" is");
		sb.append(" fun");

		// 주소가 같음 -> 하나의 메모리에서 계속 연결이 된다는 것을 알 수 있다.
		System.out.println("추가 후 sb 주소 : "+Integer.toHexString(System.identityHashCode(sb)));
		
		str = sb.toString();
		System.out.println(str);

		// 주소가 다름 -> 새로 생성됨
		System.out.println("새로 대입된 str 문자열 주소 : "+Integer.toHexString(System.identityHashCode(str)));
	}
}
