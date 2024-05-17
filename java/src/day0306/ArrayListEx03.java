package day0306;

import java.util.ArrayList;
import java.util.Date;

public class ArrayListEx03 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
//		ArrayList<String> list = new ArrayList<>();
//		String 만 받는 ArrayList -> String 아닌 값은 오류
		Date day = new Date();
		list.add("hello");
		list.add(100);
		list.add(day);
		System.out.println(list);
		
		Object obj = list.get(0);
			// public E get(int index)
			// E : Element 의 약자. 모든 타입을 의미
			// -> 모든 타입을 받을 수 있는것은 Object
		System.out.println(obj);

//		String aaa = list.get(0); // 오류
//		String aaa = (String) list.get(0);
		// 해당 인덱스의 값이 String 타입인 것을 알아서 강제변환 후 대입
		// 하지만 항상 무슨 타입인지 알 수 없음. 
		//		-> <제네릭> 사용해서 특정 타입만 가능한 list 사용할 수 있음
		
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("world");
		String str = list2.get(0);
		System.out.println(str);
	}
}
