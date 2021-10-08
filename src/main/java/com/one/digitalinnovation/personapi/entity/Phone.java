package com.one.digitalinnovation.personapi.entity;

import com.one.digitalinnovation.personapi.dto.PhoneDTO;
import com.one.digitalinnovation.personapi.enums.PhoneType;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Phone {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Enumerated(EnumType.STRING)
    private PhoneType phoneType;
    @Column(nullable = true)
    private String number;

    public Phone(PhoneDTO phoneDTO) {
        this.id = phoneDTO.getId();
        this.phoneType = phoneDTO.getPhoneType();
        this.number = phoneDTO.getNumber();
    }
}
