package day0229;

public class ChildClass1 implements ChildInterface1 {

	@Override
	public void method1() {
		System.out.println("Parent method1() 구현");
	}

	@Override
	public void method3() {
		System.out.println("Child1 method3() 구현");
	}
	
}
