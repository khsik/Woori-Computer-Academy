package com.example.thp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class TempData {
	private LocalDateTime generateTime;
	private List<Integer> nums;
	

	TempData(){
		nums = new ArrayList<Integer>();
		while(nums.size() < 6) {
			Integer i = (int)(Math.random()*45)+1;
			if(!nums.contains(i)) {
				nums.add(i);
			}
		}
		generateTime = LocalDateTime.now();
	}
}
