package com.ws.ami.mock;

public interface PersonDao {
	public Person fetchPerson(Integer personID);

	public void update(Person person);
}