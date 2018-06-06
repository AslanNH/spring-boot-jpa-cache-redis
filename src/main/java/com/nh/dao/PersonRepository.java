package com.nh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nh.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
