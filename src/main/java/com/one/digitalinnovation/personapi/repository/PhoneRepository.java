package com.one.digitalinnovation.personapi.repository;

import com.one.digitalinnovation.personapi.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, String> {
}
