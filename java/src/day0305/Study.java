package day0305;

class St1 implements Cloneable {
	// 변수
	private String str1;
	private String str2;

	// 생성자
	St1(){}
	St1(String str1, String str2){
		this.str1 = str1;
		this.str2 = str2;
	}

	// 메서드
	public String getStr1() {
		return str1;
	}
	public String getStr2() {
		return str2;
	}
	public void setStr1(String str1) {
		this.str1 = str1;
	}
	public void setStr2(String str2) {
		this.str2 = str2;
	}
	public void info() {
		System.out.println("str1 : "+str1);
		System.out.println("str2 : "+str2);
	}
	public void printHexHashCode() {
		System.out.print("Hex type HashCode : ");
		System.out.println(Integer.toHexString(str1.hashCode()>>1 + str2.hashCode()).toUpperCase());
	}

	// 메서드 오버라이드
	@Override
	protected St1 clone(){
		St1 clone = null;
		try {
			clone = (St1) super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("객체 복사를 실패했습니다.");
		}
		return clone;
	}
	
	@Override
	public String toString() {
		String result = String.format("str1 : %s, str2 : %s", str1, str2);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof St1) {
			St1 st = (St1) obj;
			if(st.str1.hashCode()==str1.hashCode() && st.str2.hashCode()==str2.hashCode()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return str1.hashCode()>>1 + str2.hashCode();
	}
	
}

public class Study {
	public static void main(String[] args) {
		St1 s1 = new St1("java", "spring");
		St1 s1c = s1.clone();
		St1 s2 = new St1("python","autumn");

		System.out.println(s1==s1c);
		System.out.println(s1.equals(s1c));

		System.out.println(s1.hashCode());
		s1.printHexHashCode();

		System.out.println(s1);
		System.out.println(s2);
	}
}
