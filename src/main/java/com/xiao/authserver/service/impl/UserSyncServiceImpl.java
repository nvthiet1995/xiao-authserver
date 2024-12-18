package com.xiao.authserver.service.impl;

import com.xiao.authserver.constants.UserConstants;
import com.xiao.authserver.dto.UserSyncDto;
import com.xiao.authserver.entity.User;
import com.xiao.authserver.mapper.UserSyncMapper;
import com.xiao.authserver.repository.UserRepository;
import com.xiao.authserver.service.UserSyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Consumer;

@Slf4j
@Service
public class UserSyncServiceImpl implements UserSyncService {

    private final UserRepository userRepository;

    private final UserSyncMapper userSyncMapper;

    private final Map<String, Consumer<UserSyncDto>> userActionHandlers;

    public UserSyncServiceImpl(UserRepository userRepository, UserSyncMapper userSyncMapper) {
        this.userRepository = userRepository;
        this.userSyncMapper = userSyncMapper;

        this.userActionHandlers = Map.of(
                UserConstants.ActionType.CREATE, this::handleCreateUser,
                UserConstants.ActionType.UPDATE, this::handleUpdateUser,
                UserConstants.ActionType.DELETE, this::handleDeleteUser
        );
    }

    @Override
    public void processSyncUser(String actionType, UserSyncDto userSyncDto) {
        log.info("Process sync with action {} for user with ID {}", actionType, userSyncDto.getId());
        userActionHandlers.getOrDefault(actionType, dto -> log.warn("Unsupported action type: {}", actionType))
                .accept(userSyncDto);
    }

    private void handleCreateUser(UserSyncDto userSyncDto) {
        User creatingUser = userSyncMapper.userSyncDtoToUser(userSyncDto);
        userRepository.save(creatingUser);
    }

    private void handleUpdateUser(UserSyncDto userSyncDto) {
        User updatingUser = userSyncMapper.userSyncDtoToUser(userSyncDto);
        updatingUser.setId(userSyncDto.getId());
        userRepository.save(updatingUser);
    }

    private void handleDeleteUser(UserSyncDto userSyncDto) {
        userRepository.deleteById(userSyncDto.getId());
    }
}
