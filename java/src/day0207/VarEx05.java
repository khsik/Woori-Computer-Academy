package day0207;

class VarEx05 {
	public static void main(String[] args) {
		//int num1 = 12345678900;	// 범위가 넘었기때문에 오류 발생
		long num2 = 12345678900L;	// 자바는 정수형 기본을 int로 처리
									// 식별자 사용 - L , l
		long a = 12345678900L;
		long a2 = 1000;
		System.out.println(a+a2);
	}
}
