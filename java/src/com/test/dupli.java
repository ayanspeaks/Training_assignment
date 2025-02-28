package com.test;

import java.util.HashMap;

public class dupli {
	
	public static void main(String a[]) {
		int[] arr = {1,2,3,2,4,4,4,5,6,6};
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int num:arr) {
			map.put(num,  map.getOrDefault(num, 0) + 1);
		}
		
		map.forEach((key, value) -> {
			if(value > 1) {
				System.out.println(key + " -> " + value);
			}
		});
	}

}
