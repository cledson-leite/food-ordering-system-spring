package com.cledsonleite.orderservice.config.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.protocol.Message;
import org.apache.kafka.common.serialization.Serializer;

public class CustomSerializer implements Serializer<Message> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String s, Message saleMessage) {
        try{
            if (saleMessage == null) return null;
            return objectMapper.writeValueAsBytes(saleMessage);
        }catch (Exception exception){
            throw new SerializationException("Erro ao serializar SaleMessage para byte[]");
        }
    }
}
