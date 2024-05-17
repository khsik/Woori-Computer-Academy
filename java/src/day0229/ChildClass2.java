package day0229;

public class ChildClass2 implements ChildInterface2 {

	@Override
	public void method1() {
		System.out.println("Parent method1() 구현");
	}

	@Override
	public void method3() {
		System.out.println("Child2 method3() 구현");
	}

}
