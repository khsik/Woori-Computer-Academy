package day0307;

import java.util.*;
//import java.util.Map.Entry;

public class MapEx04 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();

		// 객체 저장
		map.put("java", 85);
		map.put("jsp", 90);
		map.put("html", 80);
		map.put("spring", 95);
		map.put("spring", 50);

		System.out.println("총 Entry 수 = "+map.size());
		System.out.println(map);

		// 키 직접 대입해서 값 꺼내기
		System.out.println("key \"java\"에 저장된 value = " + map.get("java"));

		// 키 Set 컬렉션을 얻고, 반복 -> 키, 값 꺼냄
		Set<String> keySet = map.keySet();
		Iterator<String> kIter = keySet.iterator();
		System.out.println("=== keySet ===");
		while(kIter.hasNext()) {
			String k = kIter.next();
			System.out.println(k + " : " + map.get(k));
		}

		// Collection(인터페이스) Collections(클래스) 서로 다르니까 주의
		Collection<Integer> cValues = (Collection<Integer>) map.values();
		Iterator<Integer> vIter = cValues.iterator();
		System.out.println("=== values ===");
		while(vIter.hasNext()) {
			System.out.println(vIter.next());
		}

		Set<Map.Entry<String, Integer>> eSet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> eIter = eSet.iterator();
		System.out.println("=== Entry ===");
		while(eIter.hasNext()) { 
			Map.Entry<String, Integer> e = eIter.next(); // 위에서 제네릭 써둬서 (Map.Entry<String, Integer>)타입변환 안해도 됨
			System.out.println("key =  " + e.getKey() + "	value = " + e.getValue());
		} // import java.util.Map.Entry; 하면 Map.Entry 대신 Entry 라고만 써도 사용 가능함

		// .remove(K) 해당 K-V를 제거하며 V 리턴
		System.out.println("\nmap.remove(\"spring\")");
		map.remove("spring");
		System.out.println(map);

		// .clear() 전체 삭제. 리턴 없음(void)
		System.out.println("map.clear()");
		map.clear();
		System.out.println(map);
		
	}
}

/*
	클래스 Collections
	- Object 하나만 상속받은 클래스
	- Collection, List, Set, Map 에 사용 가능한 다양한 메서드 포함

	인터페이스 Collection
	- AbstractCollection 클래스 등에서 구현함
		> AbstractList, Set, Map 에서 각각의 인터페이스와 함께 상속받아 구현하고 있음
		> AbstractList, Set, Map 를 각각 상속받아 구현된 클래스가
		> ArrayList, (Hash/Tree)(Set/Map)

	인터페이스 Iterator
	- .hasNext() 내부에 값이 존재하면 true / 없으면 false
	- .next() 내부의 값 하나 리턴 후 제거(.remove() 실행)
*/