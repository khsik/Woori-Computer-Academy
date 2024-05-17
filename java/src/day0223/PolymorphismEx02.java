package day0223;

class Animal {
	public void move() {
		System.out.println("동물이 움직입니다.");
	}
}

class Human extends Animal {
	public void move() {
		System.out.println("사람이 움직입니다.");
	}

	public void eat() {
		System.out.println("사람이 과일을 먹습니다.");
	}
}

class Tiger extends Animal {
	public void move() {
		System.out.println("호랑이가 움직입니다.");
	}

	public void eat() {
		System.out.println("호랑이가 고기를 먹습니다.");
	}
}

class Cat extends Animal {
	public void move() {
		System.out.println("고양이가 움직입니다.");
	}

	public void eat() {
		System.out.println("고양이가 생선을 먹습니다.");
	}
}

public class PolymorphismEx02 {
	public static void main(String[] args) {
		PolymorphismEx02 p = new PolymorphismEx02();

		p.animalMove(new Tiger());
		
		Animal ani = new Human();
		ani.move();
//		ani.eat(); // 상속한 클래스 객체를 대입해도 가지고 있지 않은 변수, 메서드는 사용 불가

	/*
	 * Human h = new Human(); 
	 * Tiger t = new Tiger(); 
	 * Cat c = new Cat();
	 * 
	 * h.move();
	 * t.move(); 
	 * c.move();
	 * 
	 * Animal ah = h; 
	 * ah.move();
	 * Animal a = new Animal();
	 * 
	 * boolean bn;
	 * bn = ah instanceof Animal;
	 * System.out.println(bn);
	 * bn = h instanceof Animal;
	 * System.out.println(bn);
	 * bn = a instanceof Animal;
	 * System.out.println(bn);
	 * 
	 * p.animalMove(ah);
	 */
	}

	public void animalMove(Animal ani) {
		ani.move();
	}
}
