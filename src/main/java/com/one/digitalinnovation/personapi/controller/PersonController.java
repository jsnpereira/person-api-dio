package com.one.digitalinnovation.personapi.controller;

import com.one.digitalinnovation.personapi.dto.PersonDTO;
import com.one.digitalinnovation.personapi.entity.Person;
import com.one.digitalinnovation.personapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor
public class PersonController {

    PersonService personService;

    @GetMapping
    public ResponseEntity<List<PersonDTO>> getAllPerson(){
        List<PersonDTO> personsDTO =  personService.getAllPersons();
        return ResponseEntity.ok(personsDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonById(@PathVariable("id") String id){
       Optional<Person> person =  personService.getPersonById(id);
       if (person.isPresent()){
           return ResponseEntity.ok(person.get());
       } else {
            return ResponseEntity.noContent().build();
       }
    }

    @PostMapping
    public ResponseEntity<PersonDTO> createPerson(@RequestBody @Valid PersonDTO personDTO, UriComponentsBuilder uriBuilder){
        PersonDTO personSaved = personService.savePerson(personDTO);
        URI uri = uriBuilder.path("/v1/person/{id}").buildAndExpand(personSaved.getId()).toUri();
        return ResponseEntity.created(uri).body(personSaved);

    }
}
