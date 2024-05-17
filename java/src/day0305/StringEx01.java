package day0305;
import java.util.ArrayList;
public class StringEx01 {
	public static void main(String[] args) {
		byte[] b = new byte[3];
		String str = new String(b);
		// byte 배열 객체 str 에 대입
		
		String s = new String();
//		char c = s.charAt(5);
//		System.out.println(c);

		s = String.valueOf(false);
		System.out.println(s.charAt(3));
	}
}
