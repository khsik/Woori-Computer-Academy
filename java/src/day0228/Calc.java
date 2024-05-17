package day0228;

// 계산기 만들기 위한 인터페이스
public interface Calc {
	// 변수
	// public final static 생략 가능
	double PI = 3.14; // 원주율
	int ERROR = -404404404; // 오류 났을 때 사용할 에러 변수

	// 추상 메서드
	// 사칙연산
	// public abstract 생략 가능
	int add(int num1, int num2);
	int minus(int num1, int num2);
	int multi(int num1, int num2);
	int divide(int num1, int num2);

	// 디폴트 메서드
	default void description() {
		System.out.println("정수 계산기를 구현합니다.");
	}

	// 정적 메서드
	static int total(int[] arr) {
		int total = 0;
		for(int ar : arr) {
			total += ar;
		}
		return total;
	}
}
