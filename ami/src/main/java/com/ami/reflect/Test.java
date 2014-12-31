package com.ami.reflect;

import java.lang.reflect.Field;



public class Test {

	public static void main(String[] args) throws Exception{
		
		
		Field[] fields = Man.class.getDeclaredFields();
		
		Object o = Man.class.getSuperclass();
		System.out.println(o);
		for(Field field :fields)
			System.out.println(field);

		
		
/*		Person person  = new Person();
		
		person.setAge(1);
		person.setHigt(5);
		person.setName(new Date());
		
		Man man = (Man) ObjectConverterHelper.convert(person, Man.class);
		
		System.out.println(man.toString());*/
		
		

	}

}
