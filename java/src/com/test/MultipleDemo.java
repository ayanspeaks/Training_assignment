package com.test;

interface inf1{
	void fox();
	void tiger();
}

abstract class Abs{
	public void dog() {
		System.out.println("abs implemented");
	}
	
	public abstract void cat();
}

class Impl extends Abs implements inf1{
	@Override
	public void cat() {
		System.out.println("abs method overrided");
	}
	
	public void fox() {
		System.out.println("inf fox() overrided");
	}
	
	public void tiger() {
		System.out.println("inf tiger() overrided");
	}
}
public class MultipleDemo {
	
	public static void main(String a[]) {
		Impl obj = new Impl();
		
		obj.cat();
		obj.dog();
		obj.fox();
		obj.tiger();
	}
	

}
