package com.one.digitalinnovation.personapi.config.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.one.digitalinnovation.personapi.enums.PhoneType;

import java.io.IOException;

public class PhoneTypeConfigJson {

    public static SimpleModule getDateModule() {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(PhoneType.class, new PhoneTypeDeserialize());
        module.addSerializer(PhoneType.class, new PhoneTypeSerializer());
        return  module;
    }

    static class PhoneTypeSerializer extends StdSerializer<PhoneType> {

        protected PhoneTypeSerializer() {
            super(PhoneType.class);
        }

        @Override
        public void serialize(PhoneType phoneType, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

            jsonGenerator.writeString(phoneType.name());
        }
    }

    static class PhoneTypeDeserialize extends StdDeserializer<PhoneType> {
        public PhoneTypeDeserialize() {
            super(PhoneType.class);
        }

        @Override
        public PhoneType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            String value = jsonParser.getText();
            return PhoneType.valueOf(value);
        }
    }
}
