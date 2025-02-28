package com.test;

class MachineData{
	static int id = 101;
	
	int pin = 10111;
	
	static class InnerClass1{
		void disp() {
		System.out.println("static inner class"+id);
		
		}
	}
	
	class InnerClass2{
		void show() {
			System.out.println("non-static inner class"+pin);
		}
	}
}

public class staticDemo {
	
	public static void main(String a[]) {
		MachineData.InnerClass1 obj1 = new MachineData.InnerClass1();
		
		obj1.disp();
		
		MachineData obj2 = new MachineData();
		
		MachineData.InnerClass2 obj3 = obj2.new InnerClass2();
		
		obj3.show();
	}

}
