package com.test;

public class buffer {
	
	public static void main(String a[]) {
		
		StringBuffer sb = new StringBuffer("java");
		
		sb.append(" 23");
		
		System.out.println(sb);
		
		System.out.println(sb.substring(1,3));
		
		String str = "Hello";
	
	    StringBuffer sb1 = new StringBuffer(str);
	    
	    System.out.println(sb1.reverse());
	}

}
