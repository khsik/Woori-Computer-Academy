package day0222;
// Book 객체를 생성하고 실행 할 클래스 2
public class ArrayEx05_2 {
	public static void main(String[] args) {
		// 도서관
		// 객체타입 배열
		Book[] lib = new Book[5];

		// 인스턴스 생성 후 배열에 대입
		lib[0] = new Book("AAA", "aa");
		lib[1] = new Book("BBB", "bb");
		lib[2] = new Book("CCC", "cc");
		lib[3] = new Book("DDD", "dd");
		lib[4] = new Book("EEE", "ee");

		// [0] ~ [4] 5개 값 출력
		for(int i=0; i<lib.length; i++) {
			System.out.println(lib[i]); // Book 인스턴스 주소
		}

		for(int i=0; i<lib.length; i++) {
			lib[i].bookInfo(); // 제목 : 작가  출력하는 메서드
		}
	}
}
