package day0226;
/*
	추상 메서드
	- 미완성 메서드
	- 리턴타입 메서드이름(매개변수,...)	선언부
	  { ... 구현 코드... }			구현부
	- 선언부 까지만 존제하는 메서드 (= 구현부 존재하지 않음)
	- abstract 키워드, {} 대신 ; 사용
	- 상속 받은 자식클래스는 [반드시] 오버라이딩(재정의) 해야함
*/
public class AbstractEx02 {

	public static void animalSound(Animal animal) {
		animal.sound();
	}

	public static void main(String[] args) {
		// sound() 호출하는 세가지 방법
		// 1. Dog / Cat 객체 생성 후 호출
		Cat cat = new Cat();
		Dog dog = new Dog();
		cat.sound();
		dog.sound();

		// 2. 자동 타입 변환
		// 부모 변수 = 자식 객체
		Animal animal1 = new Cat();
		Animal animal2 = new Dog();
//		Animal animal3 = new Animal();
		animal1.sound();
		animal2.sound();

		// 3. 매개변수의 자동 타입 변환
		animalSound(cat);
		animalSound(new Dog());
	}
}
