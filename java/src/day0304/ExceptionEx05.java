package day0304;
/*
	예외 처리 코드
	: 프로그램에서 예외가 발생하면 갑작스러운 종료
		종료를 막고 정상 실행 후 마칠 수 있도록 처리하는 코드
	: try-catch - finally {}블럭을 이용.

	try{
		예외 발생 가능 코드
	}catch(예외클래스 e){
		예외처리
	}finally{
		항상 실행;
	}

	- 정상실행
		: 에외처리 catch 부분 넘어가고 finally 부분 실행
	- 예외발생
		: 예외처리 catch 부분 실행 후 finally 부분 실행

	여기서 finally 생략 가능
	: 예외 발생 여부와 상관없이 항상 실행할 내용이 있을 경우에 사용
*/
public class ExceptionEx05 {
	public static void main(String[] args) {
		try {
			// .forName() 매개값으로 주어진 class 존재하면 class 객체 리턴
			// class 존재하지 않으면 ClassNotFoundException 예외 발생
			Class c = Class.forName("java.lang.String2");
			// 일반예외 -> 컴파일 에러
		} catch (ClassNotFoundException e) {
			System.out.println("클래스가 존재하지 않습니다.");
		}
	}
}
