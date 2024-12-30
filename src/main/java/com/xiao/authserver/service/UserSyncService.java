package com.xiao.authserver.service;

import com.xiao.authserver.dto.UserSyncDto;

public interface UserSyncService {

    void processSyncUser(String actionType, UserSyncDto userSyncDto);
}
