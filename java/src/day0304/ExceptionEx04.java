package day0304;
/*
	ClassCastException
	타입변환
	: 상위클래스 - 하위클래스 / 인터페이스 - 구현클래스
	- 이러한 관계가 아니면 클래스는 다른 클래스로 타입을 변환할 수 없다.
	- 억지로 타입변환을 시도할 경우 발생 
*/

class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}

public class ExceptionEx04 {
	public static void main(String[] args) {
		Dog dog = new Dog();
		changeDog(dog);

		Cat cat = new Cat();
		changeDog(cat);
	}

	public static void changeDog(Animal animal) {
		// Animal animal = new Dog(); 상속, 구현 관계 전제
//		if( animal instanceof Dog ) {
			Dog dog = (Dog) animal; // if 없으면 ClassCastException 발생 가능
			System.out.println("성공");
//		}else{
//			System.out.println("실패");
//		}
	}
	
}
