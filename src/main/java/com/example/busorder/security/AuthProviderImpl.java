package com.example.busorder.security;

import com.example.busorder.service.ClientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class AuthProviderImpl implements AuthenticationProvider {

    private final ClientServiceImpl clientService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String clientName = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails userDetails = clientService.loadUserByUsername(clientName);

        if (!password.equals(userDetails.getPassword())) {
            throw new BadCredentialsException("Incorrect password");
        }
        System.out.println("--------------");
        return new UsernamePasswordAuthenticationToken(userDetails, password, Collections.emptyList());


    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
