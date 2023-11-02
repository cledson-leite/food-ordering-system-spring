package com.cledsonleite.orderservice.config.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.logging.log4j.message.Message;

public class CustomDeserializer implements Deserializer<Message> {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public Message deserialize(String topic, byte[] data) {
        try{
            if(data == null) return null;
            return objectMapper.readValue(
                    new String(data, "UTF-8"),
                    Message.class
            );
        }catch(Exception exception){
            throw new SerializationException("Erro ao deserializar byte[] para SaleMessage");
        }
    }
}