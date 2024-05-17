package webP.test;

import java.util.ArrayList;

public class RandomNumber {
	public ArrayList<Integer> arr = new ArrayList<>();
	int amount;
	
	public RandomNumber(int min, int max, int amount, boolean overlap){
		this.amount = amount;
		if(overlap) { // 중복 허용
			for(int i=0; i<amount; i++) {
				arr.add((int)((max-min+1) * Math.random()+min));				
			}
		}else { // 중복 불가
			while(true) {
				Integer tempNum = (int)((max-min+1) * Math.random()+min);
				if(arr.contains(tempNum)) {
					continue;
				}else {
					arr.add(tempNum);
				}
				if(arr.size()==amount) {break;}
			}
		}
	}
	
	public Integer getNumbers(int i) {
			return arr.get(i);
	}
}