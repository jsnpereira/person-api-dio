package com.one.digitalinnovation.personapi.service;

import com.one.digitalinnovation.personapi.dto.PersonDTO;
import com.one.digitalinnovation.personapi.dto.mapper.PersonMapper;
import com.one.digitalinnovation.personapi.entity.Person;
import com.one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonDTO> getAllPersons() {
        List<Person> persons = personRepository.findAll();
        return persons.stream().map(PersonMapper::toDTO).collect(Collectors.toList());
    }

    public PersonDTO savePerson(PersonDTO personDTO) {
        Person personCreated = personRepository.save(PersonMapper.toModel(personDTO));
        return PersonMapper.toDTO(personCreated);
    }

    public Optional<Person> getPersonById(String id) {
        return personRepository.findById(id);
    }

    public void deletePerson(PersonDTO personDTO) {
        personRepository.delete(PersonMapper.toModel(personDTO));
    }


}
