package com.one.digitalinnovation.personapi.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.one.digitalinnovation.personapi.entity.Person;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class PersonDTO {
    private String id;
    @NotNull @NotEmpty @Size(min = 3, max = 25)
    private String firstName;
    @NotNull @NotEmpty @Size(min = 5, max = 25)
    private String lastName;
    private String cpf;
    @NotNull
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate birthDate;

    public PersonDTO(Person person) {
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.cpf = person.getCpf();
        this.birthDate = person.getBirthDate();
    }

    public PersonDTO() {
    }

    public static List<PersonDTO> convertToDTO(List<Person> persons){
        return persons.stream().map(PersonDTO::new).collect(Collectors.toList());
    }
}
