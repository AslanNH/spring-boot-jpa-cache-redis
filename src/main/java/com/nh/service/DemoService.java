package com.nh.service;

import com.nh.domain.Person;

public interface DemoService {

	public Person save(Person person);
	
	public void remove(Long id);
	
	public Person findOne(Person person);
}
