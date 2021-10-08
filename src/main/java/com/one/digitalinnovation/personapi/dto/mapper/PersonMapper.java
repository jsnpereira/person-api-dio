package com.one.digitalinnovation.personapi.dto.mapper;

import com.one.digitalinnovation.personapi.dto.PersonDTO;
import com.one.digitalinnovation.personapi.dto.PhoneDTO;
import com.one.digitalinnovation.personapi.entity.Person;
import com.one.digitalinnovation.personapi.entity.Phone;
import java.util.List;
import java.util.stream.Collectors;


public class PersonMapper  {

    public static Person toModel(PersonDTO personDTO) {
        Person person = new Person();
        person.setId(personDTO.getId());
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        person.setCpf(personDTO.getCpf());
        List<Phone> phones = personDTO.getPhones().stream().map(Phone::new).collect(Collectors.toList());
        person.setPhones(phones);
        return person;
    }


    public static PersonDTO toDTO(Person person) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(person.getId());
        personDTO.setFirstName(person.getFirstName());
        personDTO.setLastName(person.getLastName());
        personDTO.setCpf(person.getCpf());
        List<PhoneDTO> phoneDTOS;
        phoneDTOS = person.getPhones().stream().map(PhoneDTO::new).collect(Collectors.toList());
        personDTO.setPhones(phoneDTOS);
        return personDTO;
    }
}
