package day0223.protected_2;

//import day0223.protected_1.A;

//public class D extends A {
public class DD extends day0223.protected_1.A {
	public String vd1 = "public";
	protected String vd2 = "protected";
	String vd3 = "default";
	
	public DD() {
//		A a = new A();
//		a.var = "value";
//		a.method();
		super();
		this.var = "value";
		this.method();
	}
}
