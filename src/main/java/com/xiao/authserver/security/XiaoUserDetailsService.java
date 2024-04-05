package com.xiao.authserver.security;

import com.xiao.authserver.entity.User;
import com.xiao.authserver.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class XiaoUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public XiaoUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.findByEmailAddress(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Could not find user with email: %s", email)));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.EMPTY_LIST);
    }
}
