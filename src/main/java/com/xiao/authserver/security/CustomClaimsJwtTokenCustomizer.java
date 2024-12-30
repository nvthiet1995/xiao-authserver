package com.xiao.authserver.security;

import com.xiao.authserver.entity.User;
import com.xiao.authserver.repository.UserRepository;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenType;
import org.springframework.security.oauth2.server.authorization.token.JwtEncodingContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenCustomizer;
import org.springframework.stereotype.Component;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.Optional;

@Component
public class CustomClaimsJwtTokenCustomizer implements OAuth2TokenCustomizer<JwtEncodingContext> {

    private final UserRepository userRepository;

    public CustomClaimsJwtTokenCustomizer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void customize(JwtEncodingContext context) {
        if (OAuth2TokenType.ACCESS_TOKEN.equals(context.getTokenType())) {
            String username = context.getPrincipal().getName();
            Optional<User> loggingUser = userRepository.findByUsername(username);
            List<String> roles = context.getPrincipal().getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
            loggingUser.ifPresent(user -> context.getClaims().claim("ref_user_id", user.getRefUserId()).claim("roles", roles));
        }
    }
}