package day0221;
/*
	배열
	- 데이터 타입(자료형)이 같은 데이터를 한번에 모아놓은 것
	- 연속적으로 나열된 구조 (순서가 있음)
	- 각 값에 index를 부여
	- 생성과 동시에 길이(크기, 개수)가 정해진다.
	- 길이를 변경할 수 없다.
 */
public class ArrayEx01 {
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		int num3 = 30;
		int num4 = 40;
		int num5 = 50;
//		6, 7, 8, ...
		int num100 = 1000; // 타입이 같음 -> 배열 가능
		
		// 배열의 선언
		// 타입 변수이름;
		int[] intArray;
		double[] doubleArray;
		String[] stringArray;
		
		// 배열 생성
		// 1. 선언할 때 값을 초기화
		int[] arr = {1, 2, 3, 4, 5};

		// 자바 프로그램에서는 0부터 시작
		// 인덱스 연산자 [] : 배열 요소가 지정된 메모리 위치를 찾아주는 역할
		// 배열이름[인덱스번호]
		// 배열의 값 읽기
		System.out.println("arr[1] : " + arr[1]); // 2
		System.out.println("arr[0] : " + arr[0]); // 1
		System.out.println("arr[3] : " + arr[3]); // 4
		System.out.println("arr[4] : " + arr[4]); // 5

		// 배열의 값 변경
		arr[0] = 30;
		System.out.println("arr[0] 수정 후 : " + arr[0]); // 30
		
		// 배열 생성
		// 2. 배열의 개수를 지정하여 선언한다면, 타입에 따라 초기화 (타입별 기본값)
		int[] arr2 = new int[5];
		System.out.println(arr2);
		
		arr2[0] = 100;
		arr2[1] = 200;
		arr2[2] = 300;
		System.out.println("arr2[2] : " + arr2[2]);
		System.out.println("arr2[3] : " + arr2[3]);
		System.out.println("arr[4] : " + arr2[4]);
		
		// 배열 생성
		// 3. 배열 선언 후 생성
		int[] arr3;
//		arr3 = {30, 40, 50, 60};
		arr3 = new int[] {30, 40, 50, 60};
	}
}
