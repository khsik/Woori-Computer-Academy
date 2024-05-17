package classTest;

public class GlobalStudent {
	String name;
	String clothesColor;
	GlobalStudent(){}
	GlobalStudent(String name, String color){
		this.name = name;
		clothesColor = color;
	}
	
	public static void main(String[] args) {
		GlobalStudent st1 = new GlobalStudent("java", "green");
		GlobalStudent st2 = new GlobalStudent();
		st2.name = "c#";
		st2.clothesColor = "yellow";
		GlobalStudent st3 = new GlobalStudent("python", "orange");

		System.out.println(st1.name);
		System.out.println(st1.clothesColor);
		System.out.println(st2.name);
		System.out.println(st2.clothesColor);
		System.out.println(st3.name);
		System.out.println(st3.clothesColor);
	}
}
