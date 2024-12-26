package com.xiao.authserver.mapper;

import com.xiao.authserver.dto.UserSyncDto;
import com.xiao.authserver.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserSyncMapper {

    @Mapping(source = "id", target = "refUserId")
    @Mapping(target = "id", ignore = true)
    User userSyncDtoToUser(UserSyncDto userSyncDto);

}