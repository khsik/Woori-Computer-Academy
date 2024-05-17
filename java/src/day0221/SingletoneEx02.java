package day0221;

class Phone {
	 public int number = 1234;

	 private static Phone p = new Phone();
	 private Phone() {}
	 
	 public static Phone getInstance() {
		 return p;
	 }
}

public class SingletoneEx02 {
	public static void main(String[] args) {
		Phone p1 = Phone.getInstance();
		Phone p2 = Phone.getInstance();

		System.out.println(p1);
		System.out.println(p2);

		System.out.println(p1.number);

		p2.number = 20;
		System.out.println(p2.number);
		System.out.println(p1.number);
	}
}
