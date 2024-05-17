package day0306;

import java.util.TreeSet;

public class SetEx02 {
	public static void main(String[] args) {
		TreeSet ts = new TreeSet();
		ts.add('F');
		ts.add('A');
		ts.add('z');
		ts.add('c');
		ts.add('B');
		ts.add('K');
		System.out.println(ts);
		
		TreeSet ts2 = new TreeSet();
		for(int i=0; ts2.size()<6; i++) {
			int num = (int)(Math.random()*45+1);
			ts2.add(new Integer(num));
		}
		System.out.println(ts2);
	}
}
