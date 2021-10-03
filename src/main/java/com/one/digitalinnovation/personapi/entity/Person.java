package com.one.digitalinnovation.personapi.entity;

import com.one.digitalinnovation.personapi.dto.PersonDTO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
@Setter
@Getter
public class Person {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String firstName;
    private String lastName;
    private String cpf;
    private LocalDate birthDate;

    public Person(PersonDTO personDTO) {
        this.id = personDTO.getId();
        this.firstName = personDTO.getFirstName();
        this.lastName = personDTO.getLastName();
        this.cpf = personDTO.getCpf();
        this.birthDate = personDTO.getBirthDate();
    }

    public Person() {
    }
}
