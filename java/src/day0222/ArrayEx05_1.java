package day0222;
// Book 객체를 생성하고 실행하는 클래스
public class ArrayEx05_1 {
	public static void main(String[] args) {
		// 도서관
		// 객체 배열 생성
		// 타입[] 이름 = new 타입[5];
		Book[] lib = new Book[5];	// Book 타입이고 길이가 5인 배열 lib 생성
									// Book 인스턴스는 아직 생성 안됐음.
//		int[] a = new int[5];	// 이거랑 비교해보면 알기 쉬움
								// int 타입의 배열 생성. 값 대입은 안되어있음.

//		Book lib = new Book(); 인스턴스 생성

		for(int i=0; i<lib.length; i++) {
			System.out.println(lib[i]); // 객체 타입이고 초기화 안함. 기본값 null
		}

//		lib[0] = new Book();
//		lib[1] = new Book();

//		for(int i=0; i<lib.length; i++) {
//			lib[i] = new Book();
//		}

	}
}
