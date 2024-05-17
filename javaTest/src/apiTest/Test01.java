package apiTest;
/*
	1.  배열에 중복된 데이터를 제거하고  출력하는 프로그램을 작성하시오. (데이터출력시 순서는 상관없음)
		arr[] = {10, 20, 30, 40, 50, 60, 70, 40, 30, 20} 
*/
import java.util.HashSet;
import java.util.Iterator;
public class Test01 {
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50, 60, 70, 40, 30, 20};

		// 조건문 활용
		for(int i=0; i<arr.length; i++) {
			boolean temp = false; // i 보다 앞에 중복되는 값 있으면 true
			for(int j=i-1; j>=0; j--) { // i 보다 앞선 위치에 arr[i]와 같은 값이 있나 체크
				if(arr[i] == arr[j]) {
					temp = true;
					arr[i] = 0; // 중복된 값 초기화
					break;
				}
			}
			if(!temp) {
				System.out.println(arr[i]);
			}
		}
		// 만약 배열의 크기도 조절이 필요하다면 int count 하고 초기화 할때마다 count++ 해서 새로운 배열의 길이 구해냄
		// 그리고 새로운 배열에는 초기화된 값이면 대입하지 않도록 for 내부에 if 조건으로 체크 후 대입

		// HashSet 활용. 정렬 원하면 마지막에 TreeSet 혹은 List 변환 후 Collections.sort 사용.
		System.out.println("\n= HashSet =");
		int[] arr2 = {10, 20, 30, 40, 50, 60, 70, 40, 30, 20};
		HashSet<Integer> hset = new HashSet<>();
		for(int ar : arr2) {
			hset.add(ar);
		}
		Iterator<Integer> iter = hset.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
