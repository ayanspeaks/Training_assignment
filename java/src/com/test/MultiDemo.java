package com.test;


class C{
	public void method1(){
		System.out.println("Top most parent");
	}
}

class D extends C{
	public void method2() {
		System.out.println("Intermediate base class");
	}
}

class E extends D{
	public void method3() {
		System.out.println("Bottom most child class");
	}
}

public class MultiDemo {
	
	public static void main(String a[]) {
		E obj = new E();
		
		obj.method3();
		obj.method2();
		obj.method1();
	}

}
