package day0228;

public class InterfaceEx02 {
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 5;
		
		CompleteCalc calc = new CompleteCalc();
		System.out.println(calc.add(num1, num2));
		System.out.println(calc.minus(num1, num2));
		System.out.println(calc.multi(num1, num2));
		System.out.println(calc.divide(num1, num2));
		calc.info();
		
		Calc calc2 = new CompleteCalc();
//		calc2.info(); // 호출 불가. CompleteCalc 객체의 것.
		
	}
}
