package day0306;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEx05 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(10));	// list.add(10); 하고 같지만 객체 활용
		list.add(new Integer(5));	// index 1 에 5 대입 : 정확히는 Integer 의 주소 대입
		list.add(new Integer(4));
		list.add(new Integer(2));
		list.add(new Integer(0));
		list.add(new Integer(1));
		list.add(new Integer(3));

		// 이상 미만
		list.subList(1, 4);

		ArrayList list2 = new ArrayList(list.subList(1, 4));
		System.out.println(list);
		System.out.println(list2);

		// .sort() : 정렬 기능 - 오름차순
		System.out.println(list);
		list.sort(null);
		Collections.sort(list2);
		System.out.println(list);		
		System.out.println(list2);
		Collections.reverse(list);
		Collections.sort(list2, Collections.reverseOrder());
		System.out.println(list);
		System.out.println(list2);

//		System.out.println("======================");
//		list.sort(null);
//		System.out.println(list);
//		Collections.sort(list, Collections.reverseOrder());
//		list.sort(Collections.reverseOrder());
//		System.out.println(list);

		// .contains - true / false
		System.out.println(list.contains(0));
		System.out.println(list2.contains(0));

		System.out.println(list.containsAll(list2));
		System.out.println(list2.containsAll(list));

		// .retainAll() 교집합
		list.retainAll(list2);
		System.out.println(list);
		System.out.println(list2);
	}
}
