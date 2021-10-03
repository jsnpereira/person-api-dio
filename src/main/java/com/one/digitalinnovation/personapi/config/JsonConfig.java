package com.one.digitalinnovation.personapi.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.one.digitalinnovation.personapi.utils.DateUtils;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Date;


@Configuration
public class JsonConfig {
    private String BIRTHDAY_DATE_PATTERN = "YYYY-MM-DD";

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.registerModule(setDateModule());
        return objectMapper;
    }

    private SimpleModule setDateModule() {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Date.class, new DateDeserialize());
        module.addSerializer(Date.class, new DateSerializer());
        return  module;
    }

    class DateSerializer extends StdSerializer<Date> {

        protected DateSerializer() {
            super(Date.class);
        }

        @Override
        public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

            jsonGenerator.writeString(DateUtils.toString(date, BIRTHDAY_DATE_PATTERN));
        }
    }

    class DateDeserialize extends StdDeserializer<Date> {
        public DateDeserialize() {
            super(Date.class);
        }

        @SneakyThrows
        @Override
        public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            String value = jsonParser.getText();
            return DateUtils.toDate(value, BIRTHDAY_DATE_PATTERN);
        }
    }
}
