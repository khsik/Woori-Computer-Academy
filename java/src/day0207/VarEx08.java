package day0207;

class VarEx08 {
	public static void main(String[] args) {
		// 강제 타입 변환 () : 캐스팅 연산자
		// 큰 타입 -> 작은 타입 대입
		// 변환 '하려는' 타입 명시해줘라
		int a = 65;
//		char b = a; 대입불가
		char b = (char)a;
		System.out.println(a);
		System.out.println(b);

		// 실수 > 정수
		double x = 10.5;
		int y = (int)x;		// 0.5의 정보의 손실 발생
		System.out.println(x);
		System.out.println(y);

		double z = y;		// 다시 double형으로 바꾸어도 돌아오지 않는다.
		System.out.println(z);

		// 정수 : byte < char < short < int < long - int
		// 실수 : float < double					- double

		// 서로 다른 타입끼리의 변환 생략 하지 마라
		// 변환(대입)하려는 쪽의 타입 반드시 적어라
	}
}
