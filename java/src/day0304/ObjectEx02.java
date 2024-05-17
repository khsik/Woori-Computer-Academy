package day0304;

import java.util.Date;

/*
	객체 문자 정보 toString()
	- 객체의 문자 정보를 리턴
	- 기본적으로 Object 클래스의 toString() 메서드는
		클래스명@16진수해시코드 로 구성된 문자 정보 리턴 : 객체 주소
	- 하위 클래스에서 오버라이딩 하여 유익한 정보를 리턴

*/
public class ObjectEx02 {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Date obj2 = new Date();
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
	}
}
