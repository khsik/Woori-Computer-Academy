package webP.test;
import java.util.ArrayList;

public class RandomNumber2 {
	private int max;
	private int min;
	private int amount;
	private boolean overlap;
	private boolean sort;
	
	public RandomNumber2(int max,int min,int amount,boolean overlap,boolean sort){
		this.max = max;
		this.min = min;
		this.amount = amount;
		this.overlap = overlap;
		this.sort = sort;
	}
	
	public String getNumbers() {
		ArrayList<Integer> arr = new ArrayList<>();
		if(overlap) {
			for(int i=0; i<amount; i++) {
				arr.add((int)((max-min+1) * Math.random()+min));				
			}
		}else {
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
		if(sort) {arr.sort(null);}
		return arr.toString();
	}
}
