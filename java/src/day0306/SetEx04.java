package day0306;

import java.util.HashSet;

class Tv {}

public class SetEx04 {
	public static void main(String[] args) {
		HashSet hs = new HashSet();
		hs.add("aaa");
		hs.add("aaa");
		hs.add(new Tv());
		hs.add(new Tv());
		System.out.println(hs);	
	}
}
