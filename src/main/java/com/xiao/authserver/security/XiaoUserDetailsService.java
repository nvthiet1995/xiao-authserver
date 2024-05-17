package com.xiao.authserver.security;

import com.xiao.authserver.entity.Role;
import com.xiao.authserver.entity.User;
import com.xiao.authserver.repository.UserRepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getUserAuthority(user));
    }

    private List<SimpleGrantedAuthority> getUserAuthority(User user){
        Set<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorise = new ArrayList<>();
        for(Role role : roles){
            authorise.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorise;
    }
}
