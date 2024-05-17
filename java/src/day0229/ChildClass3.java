package day0229;

public class ChildClass3 implements ChildInterface3 {

	@Override
	public void method1() {
		System.out.println("Parent method1() 구현");
	}

	@Override
	public void method2() {
		System.out.println("Child3 재선언 method2() 구현");
	}

	@Override
	public void method3() {
		System.out.println("child3 method3() 구현");
	}

}
