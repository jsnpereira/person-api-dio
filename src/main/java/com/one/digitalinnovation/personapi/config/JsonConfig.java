package com.one.digitalinnovation.personapi.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.one.digitalinnovation.personapi.config.utils.DateConfigJson;
import com.one.digitalinnovation.personapi.config.utils.PhoneTypeConfigJson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JsonConfig {
    private String BIRTHDAY_DATE_PATTERN = "YYYY-MM-DD";

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.registerModule(DateConfigJson.getDateModule());
        objectMapper.registerModule(PhoneTypeConfigJson.getDateModule());
        return objectMapper;
    }


}
