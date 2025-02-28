package com.test;

public class ReverseArray {
	
	public static void main(String a[]) {
		int arr[] = {1,4,67,3};
		int rev[] = new int[arr.length];
		
		for(int i=0; i<arr.length; i++) {
			rev[i] = arr[arr.length-1-i];
		}
		
		
		for(int i:rev) {
			System.out.print(i + " ");
		}
	}

}
