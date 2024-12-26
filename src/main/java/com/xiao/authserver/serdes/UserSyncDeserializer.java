package com.xiao.authserver.serdes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiao.authserver.dto.UserSyncDto;
import org.apache.kafka.common.serialization.Deserializer;

public class UserSyncDeserializer implements Deserializer<UserSyncDto> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public UserSyncDto deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, UserSyncDto.class);
        } catch (Exception e) {
            throw new RuntimeException("Error deserializing User object", e);
        }
    }
}