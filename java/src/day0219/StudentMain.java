package day0219;

public class StudentMain {
	public static void main(String[] args) {
		Student s1 = new Student();

		System.out.println(s1.name);
		s1.name = "java";
		System.out.println(s1.name);
		String name = s1.getName();
		System.out.println(name);
		
		// 학생2 객체 생성
		Student s2 = new Student();

		// 이름 저장하는 메서드
		s2.setName("jsp");
		String name2 = s2.getName();
		System.out.println(name2);
		
		// showInfo() 호출
		s1.address = "태광빌딩 6층";
		s2.address = "oracle";
		
		s1.showInfo();
		s2.showInfo();
	}
}
