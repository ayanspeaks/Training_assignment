package com.test;

public class StringDemo1 {
	
	public static void main(String a[]) {
		String str1 = "java";
		String str2 = "java";
		
		String str3 = new String("java");
		String str4 = new String("java");
		
		String str5 = "hello";
		
		System.out.println(str1 == str2);
		System.out.println(str3 == str4);
		System.out.println(str1 == str3);
		System.out.println(str2 == str5);
		System.out.println(str1.equals(str3));
		
		String str7 = str1.concat(" ayan");//immutable
		
		System.out.println(str7);
	}

}
