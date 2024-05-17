package day0221;

public class PersonMain {
	public static void main(String[] args) {
		Person p1 = new Person("000000");
		p1.setName("홍길동");
		String n = p1.getName();
		System.out.println(n);
		System.out.println(p1.getNUM());

		p1.setName("룰루루랄라라");
		String m = p1.getName();
		System.out.println(m);
	}
}
