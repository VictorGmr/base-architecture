package com.victor.basearchitecture.application.config.security.provider;

import com.victor.basearchitecture.application.config.security.authentication.SharedSecretAuthentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class SharedSecretAuthenticationProvider implements AuthenticationProvider {

    @Value("${app.shared-secret}")
    private String sharedSecret;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SharedSecretAuthentication sharedSecretAuthentication = (SharedSecretAuthentication) authentication;

        String headerSecret = sharedSecretAuthentication.getSharedSecret();

        if(sharedSecret.equals(headerSecret)) {
            return new SharedSecretAuthentication(null, true);
        }

        throw new BadCredentialsException("Wrong shared secret");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return SharedSecretAuthentication.class.equals(authentication);
    }
}
