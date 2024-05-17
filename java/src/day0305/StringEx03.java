package day0305;

public class StringEx03 {
	public static void main(String[] args) {
		String str = "자바 프로그래밍";

		// .length() : 문자열의 길이, 크기, 개수
		int len = str.length();
		System.out.println(len);

		// .replace() : 특정 문자열을 다른 문자열로 대체
		String str2 = str.replace("자바","java"); // "java 프로그래밍"
		System.out.println(str2);

		// 문자열 잘라내기
		// .substring(int beginIndex) : 시작(beginIndex)부터 끝까지
		String str3 = str.substring(4);
		System.out.println(str3);

		// .substring(시작(이상), 끝(미만)) : 시작 포함, 끝 미포함
		String str4 = str.substring(3, 5);
		System.out.println(str4);

		// .indexOf() : 특정 문자열의 시작 위치(index). 해당 문자열 없으면 -1
		int index = str.indexOf("프로그래밍");
		System.out.println(index);
		if( index == -1 ) {
			System.out.println("포함되지 않았습니다.");
		}else {
			System.out.println("포함되어 있습니다.");
		}

		// .contains() : 단순히 포함 여부를 물을 때 사용
		// 있으면 true, 없으면 false
		boolean contains = str.contains("프로그래밍");
		System.out.println(contains);
		if (contains) {
			// 포함 true
		}else {
			// 미포함 false
		}

		// 문자열 분리
		// .split() : 구분할 수 있는 것으로 분리할 때
		String str5 = "사과,딸기,포도,복숭아,바나나";
		String[] tokens = str5.split(",");
		System.out.println(tokens[1]+"잼");
		int in=0;
		for(String token : tokens) {
			System.out.print((++in)+"."+token+" ");
		}
		System.out.println();

		System.out.println(str.toString());
		
		// .valueOf() : static -> 클래스이름.메서드(매개값);
		// 매개값을 문자열로 리턴
		String str6 = String.valueOf(100);
		System.out.println(str6);

		// .parseInt() : 문자열을 int 타입으로 변환
		// 이때, 정수로 변환할 수 있는 문자열이 아니면 오류.
		int str7 = Integer.parseInt("1001");
		System.out.println(str7);
	}
}
