package com.one.digitalinnovation.personapi.repository;


import com.one.digitalinnovation.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository  extends JpaRepository<Person, String> {
}
