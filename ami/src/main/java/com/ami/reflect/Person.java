package com.ami.reflect;

import java.util.Date;

public class Person {
	private Date name;
	private int age;
	private int higt;
	
	
	public Date getName() {
		return name;
	}


	public void setName(Date name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getHigt() {
		return higt;
	}


	public void setHigt(int higt) {
		this.higt = higt;
	}


	public String toString() {
		return "Person = " +"name ="+name +" age ="+age +" higt ="+higt;
		
	}

}
