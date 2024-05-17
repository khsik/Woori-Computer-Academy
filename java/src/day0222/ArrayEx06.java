package day0222;
/*
	Student 클래스
	studentInfo()
		studentNum, name

	학생 3명 / for문 사용해서 메서드 출력
*/
public class ArrayEx06 {
	public static void main(String[] args) {
		Student[] st = new Student[3];
 
		st[0] = new Student(2, "java");
		st[1] = new Student(5, "c#");
		st[2] = new Student(7, "swift");

		for(int i=0; i<st.length; i++) {
			st[i].studentInfo();
		}

		System.out.println();
		st[1].setName("c++");
		st[1].setNum(3);
		st[1].studentInfo();
	}
}
