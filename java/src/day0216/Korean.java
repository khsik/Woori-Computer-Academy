package day0216;

public class Korean {
	// 변수
	String nation = "대한민국";	//모든 객체에 동일하게 들어감
	String name;
	int num;
	
	//생성자
	Korean(String name){
		this.name = name;
	}
	Korean(String name, int num){
		this.name = name;
		this.num = num;
	}
}
