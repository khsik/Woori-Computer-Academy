package day0216;

public class KoreanMain {
	public static void main(String[] args) {
		// 객체 생성
		Korean p1 = new Korean("홍길동",920101);
		Korean p2 = new Korean("김길동",880505);
		Korean p3 = new Korean("박길동",901024);
		// 변수 사용
		System.out.println(p1.nation+" "+p1.name);
		System.out.println(p2.num);
		System.out.println(p3.name +" "+ p3.num);
		
		//다른 객체인지 확인
		System.out.println(p1);
		System.out.println(p2);
	}
}
