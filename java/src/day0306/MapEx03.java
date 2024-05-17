package day0306;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Collection;

public class MapEx03 {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		
		map.put("java", new Integer(100));
		map.put("jsp", Integer.valueOf(70));
		map.put("html", new Integer(60));
		map.put("data", new Integer(90));
		System.out.println(map);
		
		Set set = map.entrySet();
		System.out.println(set);
		
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			Map.Entry e = (Map.Entry) iter.next();
			System.out.println(e.getKey() + " = " + e.getValue());
		}
		
		Set s = map.keySet();
		System.out.println(s);
		
		Collection values = map.values();

		Iterator iter2 = values.iterator();
//		Iterator<Integer> iter2 = values.iterator();
		int sum=0;
		while(iter2.hasNext()) {
			sum += (Integer) iter2.next();
//			sum += iter2.next();
		}
		System.out.println("value 합계 : "+sum);
		int avg = sum / values.size();
		System.out.println("value 평균 : "+avg);
	}
}
