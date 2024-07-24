package com.xiao.authserver.mapper;

import com.xiao.authserver.dto.UserSyncDto;
import com.xiao.authserver.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserSyncMapper {

    User userSyncDtoToUser(UserSyncDto userSyncDto);

}