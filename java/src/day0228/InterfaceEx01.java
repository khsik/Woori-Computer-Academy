package day0228;
/*
	인터페이스 (InterfaceEx)
	- 객체의 사용방법을 정의한 타입
	- 개발 코드를 수정하지 않고 객체를 변경할 수 있도록 하기 위함.
	- 여러 객체들과 사용 가능하므로 어떤 객체를 사용하느냐에 따라
		실행결과, 리턴값이 다를 수 있다.

	인터페이스의 선언
	public interface 인터페이스명 {...}
	- public : 다른 패키지에서도 인터페이스에 접근이 가능
	- interface 키워드 사용
	- 인터페이스명 클래스 명명 규칙과 같다. (첫글자 대문자)

	구성 요소
	- 클래스 : 변수, 생성자, 메서드
	- 인터페이스 : 상수 변수, 추상 메서드
				java 8버전부터 default 메서드, static 메서드 사용 가능
	
	interface 인터페이스명{	아래 [] 안에 있는거는 안적어도 컴파일 하면서 자동으로 추가
		// 상수 변수
		[public static final] 타입 변수명 = 값;
		// 추상 메서드
		[public abstract] 리턴타입 메서드명();
		// 디폴트 메서드
		[public] default 리턴타입 메서드명(매개변수){구현부}
		// 정적 메서드
		[public] static 리턴타입 메서드명(매개변수){구현부}
	}
	
	구현 클래스
	- 보통의 클래스와 동일
	- 인터페이스 타입으로 사용할 수 있음을 알려주는 implements 사용 후 인터페이스명 써준다.
	- 추상메서드들을 반드시 구현해아 한다.
		이때, public 접근제어자 생략 안됨.
	- 구현 객체를 인터페이스 변수에 대입해서 사용
			인터페이스 변수;
			변수 = 구현 객체;

			인터페이스 변수 = 구현객체;
*/
public class InterfaceEx01 {
	public static void main(String[] args) {
		RemoteControl rc;
		rc = new Television();
		rc = new Audio();		// 대입 가능 확인
		
		// 인터페이스 변수 선언
		RemoteControl rc2 = null;
		
		// Tv 객체를 인터페이스에 대입
		rc2 = new Television();
		rc2.turnOn();
		rc2.setVolume(16);
		rc2.setMute(true);
		rc2.setMute(false);
		rc2.turnOff();
		RemoteControl.changeBattery();
		System.out.println();

		RemoteControl rc3 = new Audio();
		rc3.turnOn();
		rc3.setMute(false);
		rc3.setVolume(5);
		rc3.turnOff();
	}
}
