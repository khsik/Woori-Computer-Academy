package day0227;
// 추상 메서드를 모두 구현하지 않음 -> 추상 메서드 하나를 가짐 -> 추상 클래스
public abstract class NoteBook extends Computer {
	@Override
	public void displaying() {
		System.out.println("NoteBook displaying()");
	}
/*
	@Override
	public void typing() {

	}
*/
}
