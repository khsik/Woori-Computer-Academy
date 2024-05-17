package day0223;
/*
	day0223.protected_1,2
	protected
	- A, B 클래스 : 같은 패키지 접근 가능
	- C 클래스 : 다른 패키지 접근 불가능
	- D 클래스 : 다른 패키지에 있으나 상속받아 접근 가능
				new 연산자를 이용해서 생성하는 것은 못함
				반드시 조상의 생성자를 호출해서 사용
			다른 main 이 있는 클래스에서 객체 생성으로 호출하고 사용.
			그런데 다른 패키지면 객체로 생성해도 protected 접근 불가능
*/
import day0223.protected_2.*;
public class InheritanceEx05 {
	public static void main(String[] args) {
		DD d = new DD();
		System.out.println(d.vd1);
//		System.out.println(d.vd2); // protected
//		System.out.println(d.vd3); // default
		// 생성자로 객체 생성해도 패키지가 다르면 public 빼고는 접근 불가 
	}
}
