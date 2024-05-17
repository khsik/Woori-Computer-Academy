package day0227;
/*
	메서드의 선언부
		리턴타입 메서드명(매개변수)
		어떤 기능을 하는 메서드인지 알 수 있음
		: 메서드가 할 일을 명시해 두는것
	
	구현된 메서드	- 하위 클래스에서 공통으로 사용하는 메서드
	추상 메서드	- 하위 클래스가 어떤 클래스인지에 따라 구현 코드가 달라진다
*/
public class Main01 {
	public static void main(String[] args) {
		// 조상타입 변수 = 자손 객체
		Computer cd = new DeskTop();
		Computer cmn = new MyNoteBook();
//		NoteBook nmn = new MyNoteBook();

		// 메서드 전부 호출
		cd.turnOn();
		cd.displaying();
		cd.typing();
		cd.turnOff();
		System.out.println();

		cmn.turnOn();
		cmn.displaying();
		cmn.typing();
		cmn.turnOff();
		System.out.println();

//		nmn.turnOn();
//		nmn.displaying();
//		nmn.typing();
//		nmn.turnOff();
	}
}
