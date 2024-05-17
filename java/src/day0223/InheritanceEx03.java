package day0223;
/*
	Computer - Calculator 실행 클래스
	
	오버라이딩
	- 메서드 재정의
	- 메서드가 오버라이딩 되었다면 조상의 메서드 숨겨짐
		자손 객체에서 메서드 호출하면 오버라이딩 된 메서드 호출된다.
	
	어노테이션
	- 생략 가능
	- 메서드가 정확히 오버라이딩 되었는지 컴파일러가 체크 (@Override)
	- 개발자의 실수 줄여줌
*/
public class InheritanceEx03 {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		Computer com = new Computer();

		double a = cal.areaCircle(10.0);
		System.out.println(a);

		double b = com.areaCircle(10);
		System.out.println(b);
	}
}
