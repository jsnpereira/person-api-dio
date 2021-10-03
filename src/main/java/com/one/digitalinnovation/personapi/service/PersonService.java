package com.one.digitalinnovation.personapi.service;

import com.one.digitalinnovation.personapi.entity.Person;
import com.one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public Optional<Person> getPersonById(String id) {
        return personRepository.findById(id);
    }

    public void deletePerson(Person person) {
        personRepository.delete(person);
    }



}
