package com.one.digitalinnovation.personapi.dto;

import com.one.digitalinnovation.personapi.entity.Phone;
import com.one.digitalinnovation.personapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {
    private String id;
    @NotNull
    private PhoneType phoneType;
    private String number;

    public PhoneDTO(Phone phone) {
        this.id = phone.getId();
        this.phoneType = phone.getPhoneType();
        this.number = phone.getNumber();
    }

}
