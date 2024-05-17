package day0223;
/*
	Student 의 실행 클래스
*/
public class InheritanceEx02 {
	public static void main(String[] args) {
		Student st = new Student("java", "990924", 23022311);
		
		System.out.println(st.name);
		System.out.println(st.peopleNo);

		System.out.println(st.studentNo);
	}
}
