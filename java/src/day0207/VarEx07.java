package day0207;

class VarEx07 { // 형변환
	public static void main(String[] args) {
		// 자동 타입 변환
		// 작은 타입 -> 큰 타입 대입
		// 실수 > 정수
		char a = 'A';
		System.out.println(a);
		int b = a;
		System.out.println(b);
		double c = a;	// 한개의 소수점을 가진다
		System.out.println(c);

		// 정수 : byte < char < short < int < long - int
		// 실수 : float < double					- double

	}
}
