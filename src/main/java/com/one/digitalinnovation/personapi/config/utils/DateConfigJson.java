package com.one.digitalinnovation.personapi.config.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import com.one.digitalinnovation.personapi.utils.DateUtils;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.Date;

public class DateConfigJson {
    private static String BIRTHDAY_DATE_PATTERN = "YYYY-MM-DD";

    public static SimpleModule getDateModule() {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Date.class, new DateDeserialize());
        module.addSerializer(Date.class, new DateSerializer());
        return module;
    }

    static class DateSerializer extends StdSerializer<Date> {


        protected DateSerializer() {
            super(Date.class);
        }

        @Override
        public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

            jsonGenerator.writeString(DateUtils.toString(date, BIRTHDAY_DATE_PATTERN));
        }
    }

    static class DateDeserialize extends StdDeserializer<Date> {
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
