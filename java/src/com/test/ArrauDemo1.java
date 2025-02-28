package com.test;

class Student{
	private int id;
	private String name;
	private String city;
	public Student() {
		
	}
	
	public Student(int id, String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}

public class ArrauDemo1 {
	
	public static void main(String a[]) {
	Student obj1 = new Student();
	
	obj1.setId(101);
	obj1.setName("Ayan");
	obj1.setCity("Kolkata");
	
	Student obj2 = new Student(201, "Rahul", "Pune");
	
	Student[] stdData = {obj1, obj2};
	
	for(int i=0; i<stdData.length; i++) {
		System.out.println(stdData[i]);
	}
	
	for(Student obj : stdData) {
		System.out.println(obj);
	}
	}
}
