package day0220;

class Person {
	// final 변수의 초기화 방법
	// 1. 선언과 동시에 초기화
	// 2. 생성자 초기화
	final String nation = "Korea";
	final String birth;
	String name;
	
	Person(String birth, String name){
		this.birth = birth;
		this.name = name;
	}
}

public class FinalEx02 {
	public static void main(String[] args) {
		Person p1 = new Person("20001111", "java");
		Person p2 = new Person("19990622", "spring");
//		Person.birth 는 final 이지만 초기화 안되어 있어서 인스턴스 생성하며 초기화
		
		System.out.println(p1.nation + " " + p1.birth + " " + p1.name);
		System.out.println(p2.nation + " " + p2.birth + " " + p2.name);

//		p1.nation = "USA"; // final 선언한 변수라 대입(변경) 불가능
//		p1.birth = "20001001"; // final 변수라 대입 불가능
		p1.name = "python";
		System.out.println(p1.nation + " " + p1.birth + " " + p1.name);
	}
}
