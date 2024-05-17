package day0306;

import java.util.HashMap;

public class MapEx01 {
	public static void main(String[] args) {
		HashMap<Integer, String> hm = new HashMap<>();
		
		// .put(키, 값) : 값 넣기
		hm.put(33, "pw");
		hm.put(100, "java");
		System.out.println(hm);

		hm.put(100, "test");
		System.out.println(hm);

		System.out.println(hm.get(100));
		String sValue = hm.get(33);
		System.out.println(sValue);
	}
}
