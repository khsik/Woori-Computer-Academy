package day0305;
/*
	.equals()
	- 원형 : 두 객체(인스턴스)의 주소값을 비교하여 boolean 값 (T/F) 리턴
	- 물리적 동일성 : 주소 같음.
	- 논리적 동일성 : 객체에 저장된 메모리의 값이 같음.
 */

class Student {
	// 변수
	String studentName;	// 이름
	int studentId;		// 학번
	
	// 생성자
	Student(String studentName, int studentId){
		this.studentName = studentName;
		this.studentId = studentId;
	}
	
	// 메서드
	@Override
	public String toString() {
		String result = studentName+" , "+studentId;
//		String result = super.toString()+"\n"+studentName+" , "+studentId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) { // 타입 먼저 확인
			Student std = (Student) obj;
			if( studentId == std.studentId ) { // 학번이 같은지 확인 -> true 리턴
				return true;
			}
		}
		return false;
	}

	// .hashCode() 재정의
	@Override
	public int hashCode() {
		return studentId;
	}
	
}

public class ObjectEx02_1 {
	public static void main(String[] args) {
		Student stuA = new Student("java", 2024);
		Student stuA2 = stuA;
		Student stuB = new Student("java", 2024);

		// 동일한 주소의 두 객체 비교
		if( stuA == stuA2 ) {
			System.out.println("stuA와 stuA2의 주소가 같습니다.");
		}else {
			System.out.println("stuA와 stuA2의 주소가 다릅니다.");
		}

		if(stuA.equals(stuA2)) {
			System.out.println("stuA와 stuA2는 동일합니다.");
		}else {
			System.out.println("stuA와 stuA2는 동일하지 않습니다.");
		}

		// 주소가 다른 두 객체 비교
		if(stuA == stuB) {
			System.out.println("stuA와 stuB의 주소가 같습니다.");
		}else {
			System.out.println("stuA와 stuB의 주소가 다릅니다.");
		}

		if(stuA.equals(stuB)) {
			System.out.println("stuA와 stuB는 동일합니다.");
		}else {
			System.out.println("stuA와 stuB는 동일하지 않습니다.");
		}
		
		// .hashCode() 메서드 호출
		System.out.println("sutA의 hashCode 값 : "+stuA.hashCode());
		System.out.println("sutB의 hashCode 값 : "+stuB.hashCode());

		// System.identityhashCode(객체) 실제 객체의 주소 확인
		System.out.println("stuA의 실제 주소값 : "+System.identityHashCode(stuA));
		System.out.println("stuB의 실제 주소값 : "+System.identityHashCode(stuB));
//		System.out.println("stuA의 실제 주소값 : "+Integer.toHexString(System.identityHashCode(stuA)).toUpperCase());
//		System.out.println("stuB의 실제 주소값 : "+Integer.toHexString(System.identityHashCode(stuB)).toUpperCase());
	}
}
