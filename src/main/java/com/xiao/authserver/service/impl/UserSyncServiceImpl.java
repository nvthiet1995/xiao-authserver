package com.xiao.authserver.service.impl;

import com.xiao.authserver.constants.UserConstants;
import com.xiao.authserver.dto.UserSyncDto;
import com.xiao.authserver.entity.User;
import com.xiao.authserver.mapper.UserSyncMapper;
import com.xiao.authserver.repository.UserRepository;
import com.xiao.authserver.service.UserSyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserSyncServiceImpl implements UserSyncService {

    private final UserRepository userRepository;

    private final UserSyncMapper userSyncMapper;

    public UserSyncServiceImpl(UserRepository userRepository, UserSyncMapper userSyncMapper) {
        this.userRepository = userRepository;
        this.userSyncMapper = userSyncMapper;
    }

    @Override
    public void processSyncUser(String actionType, UserSyncDto userSyncDto) {
        log.info("Process sync with action {} for user with ID {}", actionType, userSyncDto.getId());
        switch (actionType) {
            case UserConstants.ActionType.CREATE:
                User creatingUser = userSyncMapper.userSyncDtoToUser(userSyncDto);
                userRepository.save(creatingUser);
                break;
            case UserConstants.ActionType.UPDATE:
                User updatingUser = userSyncMapper.userSyncDtoToUser(userSyncDto);
                updatingUser.setId(userSyncDto.getId());
                userRepository.save(updatingUser);
                break;
            case UserConstants.ActionType.DELETE:
                userRepository.deleteById(userSyncDto.getId());
                break;
            default:
                break;
        }
    }
}
