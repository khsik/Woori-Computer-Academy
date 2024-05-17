package day0223;
/*
	Computer 의 조상 클래스
*/
public class Calculator {
	double areaCircle(double r) {
		System.out.println("Calculator 객체의 areaCircle() 실행");
		return 3.14159*r*r;
	}
}
// Math.PI 하면 좀더 정확한 파이값 사용 가능