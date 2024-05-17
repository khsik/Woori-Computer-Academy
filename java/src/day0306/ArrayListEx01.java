package day0306;

import java.util.ArrayList;

class Data {}

public class ArrayListEx01 {
	public static void main(String[] args) {
		// 객체 생성
		ArrayList list = new ArrayList();
		System.out.println(list);

		// .add() 값 넣기
		list.add(100);
		list.add("hello");
		System.out.println(list); // 순서 유지

		list.add(100);
		list.add("hello");
		System.out.println(list); // 중복 허용

		Data data = new Data();
		list.add(data);
		System.out.println(list); // 타입 상관 없다
		
		list.add(0, 77); // .add(인덱스, 값) : 0번 위치에 77 삽입
		System.out.println(list);

		list.set(0, 700); // .set(인덱스, 값) : 0번 위치 값을 700 으로 수정
		System.out.println(list);
		
		// .size() : 저장된 데이터의 수
		System.out.println(list.size());
		
		// .get(index) : index 위치의 값을 리턴
		System.out.println(list.get(0));
//		System.out.println(list.get(10)); // IndexOutOfBoundsException
		
		// .remove(index) : 지정된 index 값 삭제
		list.remove(0);
		System.out.println(list);
		
		// .clear() : 전체삭제
		list.clear();
		System.out.println(list);
	}
}
