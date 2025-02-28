package com.test;

interface Inf5{
	void human();
	void animal();
}

interface Inf6{
	void dog();
	void cat();
}

interface Inf7{
	void book();
	void color();
}

interface Inf8 extends Inf5, Inf6, Inf7{
	void dance();
}

class Impl1 implements Inf8, Inf6, Inf7, Inf5{
	public void dance() {
		System.out.println("INF8 NETHOD OVERRIDED");
	}
	
	@Override
	public void human() {
		System.out.println("Method overrided");
	}
	@Override
	public void color() {
		System.out.println("Method overrided");
	}
	@Override
	public void dog() {
		System.out.println("Method overrided");
	}
	@Override
	public void cat() {
		System.out.println("Method overrided");
	}

	@Override
	public void animal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void book() {
		// TODO Auto-generated method stub
		
	}
}

public class InfDemo1 {
	
	public static void main(String[] args) {
		Impl1 obj = new Impl1();
		
		obj.dance();
		obj.human();
		obj.color();
		obj.dog();
		obj.cat();
	}

}
