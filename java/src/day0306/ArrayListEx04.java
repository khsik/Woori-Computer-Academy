package day0306;

import java.util.ArrayList;

public class ArrayListEx04 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		// 1~10 대입 후 출력
		for(int i=1; i<11; i++) {
			list.add(i);
			System.out.println("list에 "+list.get(i-1)+" 추가");
		}
		System.out.println("list : "+list);
	}
}
