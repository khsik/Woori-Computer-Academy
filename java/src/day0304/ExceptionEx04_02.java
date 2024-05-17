package day0304;

class Animal2 {}
class Dog2 extends Animal2 {}
class Cat2 extends Animal2 {}

public class ExceptionEx04_02 {
	public static void main(String[] args) {
		Animal2 animal2 = null;
		animal2 = new Dog2();

		if(animal2 instanceof Dog2) {
			Dog2 dog2 = (Dog2) animal2;
			System.out.println("Dog2 변환 성공");
		}else {
			System.out.println("변환 실패");
		}

		Animal2 animal22 = null;
		animal22 = new Cat2();
		
		if(animal22 instanceof Dog2) {
			Dog2 dog2 = (Dog2) animal22;
			System.out.println("Dog2 변환 성공");
		}else if(animal22 instanceof Cat2) {
			Cat2 cat2 = (Cat2) animal22;
			System.out.println("Cat2 변환 성공");
		}else {
			System.out.println("변환 실패");
		}
	}
}
