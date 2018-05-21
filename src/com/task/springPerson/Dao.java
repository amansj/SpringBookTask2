package com.task.springPerson;

import java.util.List;

import com.task.spring.entity.Person;

public interface Dao {
	public String addPersonDetails(Person Person);
	public String editPersonDetails(Person person);
	public String deletePersonDetails(String personId);
	public Person list(String personId);
	public List<Person> displayAll();
	
}
