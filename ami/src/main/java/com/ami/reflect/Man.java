package com.ami.reflect;

public class Man  extends Animal{
	private String name;
	private Integer age;
	private Integer higt;
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}



	public Integer getHigt() {
		return higt;
	}



	public void setHigt(Integer higt) {
		this.higt = higt;
	}



	public String toString() {
		return "man : "+"name ="+name +" age ="+age +" higt ="+higt;
		
	}

}
