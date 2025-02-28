package com.test;

class Parent1{
	public void draw() {
		System.out.println("");
	}
}

class Child1 extends Parent1{
	@Override
	public void draw() {
		System.out.println("Circle");
	}
}

class Child2 extends Parent1{
	@Override
	public void draw() {
		System.out.println("Rectangle");
	}
}

public class PolyDemo {
	
	public static void main(String[] args) {
		
		Child1 obj1 = new Child1();
		
		obj1.draw();
		
		Child2 obj2 = new Child2();
		
		obj2.draw();
	}

}
