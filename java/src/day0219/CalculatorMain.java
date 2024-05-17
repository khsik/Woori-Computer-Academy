package day0219;

public class CalculatorMain {
	public static void main(String[] args) {
		// 객체 생성
		Calculator c = new Calculator();

		// 메서드 호출(사용)
		c.powerOn();
		
		int result = c.plus(5, 7);
		System.out.println(result);
		System.out.println(c.plus(11, 25));

		double result2 = c.divide(10, 5);
		System.out.println(result2);
		
		byte b = 4;
		byte a = 10;
		double result3 = c.divide(a, b);
		System.out.println(result3);
		
		int x = 50;
		byte y = 4;
		double result4 = c.divide(x, y);
		System.out.println(result4);
		
		int result5 = c.minus(10, 17);
		System.out.println(result5);
		
		int n1 = 11;
		int n2 = 111;
		int result6 = c.multi(n1, n2);
		System.out.println(result6);
		
		// 리턴 타입이 없는 메서드 호출
		c.powerOff();
	}
}
