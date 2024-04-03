package com.xiao.authserver.security;

import com.xiao.authserver.entity.User;
import com.xiao.authserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class XiaoUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.getUserByEmailAddress(email);
        if(user.isPresent()){
            return new XiaoUserDetails(user.get());
        }
        throw new UsernameNotFoundException("Could not find user with email: "+ email);
    }
}
