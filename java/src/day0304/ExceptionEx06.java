package day0304;

public class ExceptionEx06 {
	public static void main(String[] args) {
		String data1 = null;
		String data2 = null;

		try {
			data1 = args[0]; // 여기서 예외 발생
			data2 = args[1];
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("[실행 방법]");
			System.out.print(" java ArrayIndexOutOfBoundsException ");
			System.out.println("값1 값2");
//			return;
		}

		try {
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1 + value2;
			System.out.println(result);
		}catch(NumberFormatException e) {
			System.out.println("숫자로 변환할 수 없습니다.");
		}finally {
			System.out.println("다시 실행하세요.");
		}
	}
}
