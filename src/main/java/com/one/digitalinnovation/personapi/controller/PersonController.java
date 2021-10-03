package com.one.digitalinnovation.personapi.controller;

import com.one.digitalinnovation.personapi.dto.PersonDTO;
import com.one.digitalinnovation.personapi.entity.Person;
import com.one.digitalinnovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> getAllPerson(){
        List<Person> persons =  personService.getAllPersons();
        return ResponseEntity.ok(PersonDTO.convertToDTO(persons));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonById(@PathVariable("id") String id){
       Optional<Person> person =  personService.getPersonById(id);
       if (person.isPresent()){
           return ResponseEntity.ok(new PersonDTO(person.get()));
       } else {
            return ResponseEntity.noContent().build();
       }
    }

    @PostMapping
    public ResponseEntity<PersonDTO> createPerson(@RequestBody @Valid PersonDTO personDTO, UriComponentsBuilder uriBuilder){
        Person person = personService.savePerson(new Person(personDTO));
        URI uri = uriBuilder.path("/v1/person/{id}").buildAndExpand(person.getId()).toUri();
        return ResponseEntity.created(uri).body(new PersonDTO(person));

    }
}
