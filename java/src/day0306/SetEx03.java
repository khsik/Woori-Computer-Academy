package day0306;

import java.util.HashSet;
import java.util.Set;

public class SetEx03 {
	public static void main(String[] args) {
		Object[] objarr = {"5", "1", new Integer(1), 1, "2", "2", "3", "4", 4, "4"};
		Set st = new HashSet();

		for(Object obj : objarr) {
			st.add(obj);
		}
		System.out.println(st);

		for(int i=0; i<objarr.length; i++) {
			st.add(objarr[i]);
		}
		System.out.println(st);
	}
}
