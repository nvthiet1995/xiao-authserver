package com.xiao.authserver.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserSyncDto {

    private Long id;

    private String username;

    private String password;

    private String emailAddress;

    private Set<RoleSyncDto> roles;
}
