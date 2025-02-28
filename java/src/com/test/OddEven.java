package com.test;

public class OddEven {
	
	public static void main(String arg[]) {
		int a[] = {1,8,34,23,68,71,3};
		int even[] = new int[a.length];
		int odd[] = new int[a.length];
		int evenIndex=0;
		int oddIndex=0;
		
		for(int i=0; i<a.length; i++) {
			if(a[i]%2==0) even[evenIndex++]=a[i];
			else odd[oddIndex++]=a[i];
		}
		
		for(int i=0; i<evenIndex; i++) {
			System.out.print(even[i] + " ");
		}
		
		for(int i=0; i<oddIndex; i++) {
			System.out.print(odd[i] + " ");
		}
		
		
	}

}
