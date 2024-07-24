package com.xiao.authserver.serdes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiao.authserver.dto.UserSyncDto;
import org.apache.kafka.common.serialization.Serializer;

public class UserSyncSerializer implements Serializer<UserSyncDto> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, UserSyncDto data) {
        try {
            objectMapper.findAndRegisterModules();
            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            throw new RuntimeException("Error serializing User object", e);
        }
    }
}