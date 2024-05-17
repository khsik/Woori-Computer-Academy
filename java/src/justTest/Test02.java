package justTest;

public class Test02 {
	String a;
	String b;
	int c;
	int d;

	Test02(String a, int c){
		this(a, c, null);
	}
	
	Test02(String a, int c, String b){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	Test02(String a, String b, int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	Test02(String a, int c, String b, int d){
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
}
