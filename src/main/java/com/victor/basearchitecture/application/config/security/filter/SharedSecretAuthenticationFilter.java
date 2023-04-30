package com.victor.basearchitecture.application.config.security.filter;

import com.victor.basearchitecture.application.config.security.authentication.SharedSecretAuthentication;
import com.victor.basearchitecture.application.config.security.manager.SharedSecretAuthenticationManager;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@AllArgsConstructor
@Component
public class SharedSecretAuthenticationFilter extends OncePerRequestFilter {

    private final SharedSecretAuthenticationManager sharedSecretAuthenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String sharedSecret = String.valueOf(request.getHeader("Authorization"));

        SharedSecretAuthentication authentication = new SharedSecretAuthentication(sharedSecret, false);

        try {
            Authentication currentAuthentication = sharedSecretAuthenticationManager.authenticate(authentication);
            if(currentAuthentication.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(currentAuthentication);
                filterChain.doFilter(request, response);
            }
        } catch (BadCredentialsException exception) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, exception.getMessage());
        }

    }
}