package day0214;

class BreakEx02 {
	public static void main(String[] args) {
		for(int a=1; a<=100; a++){
			if(a%5 == 0){
				break;
			}
			System.out.println(a);
		}
		System.out.println("확인");
		System.out.println("dragon");
	}
}
