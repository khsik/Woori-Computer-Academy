package classTest;

public class Student {
	String name; // 이름
	int age; // 나이
	
	public static void main(String[] args) {
		Student st = new Student();
		st.name="sun";
		st.age=46;
		System.out.println(st.name);
		System.out.println(st.age);
	}
}
