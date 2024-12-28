package com.xiao.authserver.serdes;

import com.xiao.authserver.dto.UserSyncDto;
import org.apache.kafka.common.serialization.Serdes;

public class UserSyncSerde extends Serdes.WrapperSerde<UserSyncDto> {
    public UserSyncSerde() {
        super(new UserSyncSerializer(), new UserSyncDeserializer());
    }
}