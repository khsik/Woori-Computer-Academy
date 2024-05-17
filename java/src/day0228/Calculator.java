package day0228;

public abstract class Calculator implements Calc {

	@Override
	public int add(int num1, int num2) {
		int result = num1 + num2;
		return result;
	}

	@Override
	public int minus(int num1, int num2) {
		int result = num1 - num2;
		return result;
	}

}
