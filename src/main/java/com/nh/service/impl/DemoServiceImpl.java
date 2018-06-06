package com.nh.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.nh.dao.PersonRepository;
import com.nh.domain.Person;
import com.nh.service.DemoService;
@Service
public class DemoServiceImpl  implements DemoService {

	@Autowired
	PersonRepository personRepository;
	
	@Override
	//1缓存新增的或更新的数据到缓存，缓存名称为people，key就是person的id
	@CachePut(value="people", key="#person.id")
	public Person save(Person person) {
		Person p = personRepository.save(person);
		System.out.println("为id、key 为:" + p.getId() +"数据做了缓存");
		return p;
	}

	@Override
	//2从缓存people中删除key为id的数据
	@CacheEvict(value="people")
	public void remove(Long id) {
		System.out.println("删除了id、key为"+id+"的数据缓存");
		try {
			personRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	//3缓存key为person的id数据到缓存people中
	@Cacheable(value="people", key="#person.id")
	public Person findOne(Person person) {
		Optional<Person> p;
		try {
			p = personRepository.findById(person.getId());
			System.out.println("为id、key为:"+p.get().getId()+"数据做了缓存");
			return p.get();
		} catch (Exception e) {
			e.printStackTrace();
			return new Person();
		}
	}

}
