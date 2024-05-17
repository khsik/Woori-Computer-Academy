package day0214;

class ContinueEx02 {
	public static void main(String[] args) {
		// 1~100 3의 배수만 출력
		int i;
		for(i=1; i<=100; i++){
			if(i%3 != 0){
				continue;
			}
			System.out.print(i+" ");
		}

/*		//기다리면서 심심해서 써봄. 
		for(i=1; i<101; i++){
			boolean a;
			a = i%3==0 ? true : false ;
			if(a){System.out.println(i);}
		}
*/
	}
}
