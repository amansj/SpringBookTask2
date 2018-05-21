package com.task.springPerson;

import java.util.List;

import com.task.spring.entity.Person;

public interface Service {
	public String add(Person person);
	public String edit(Person person);
	public String delete(String personId);
	public Person list(String personId);
	public List<Person> display();
}
