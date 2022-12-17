package com.itspace.kinogospringrest.restservice.impl;

import com.itspace.kinogospringrest.restservice.userdetails.CurrentUserDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityContextServiceImpl {

    public CurrentUserDetails getUserDetails() {
        return (CurrentUserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }
    public  void setAuthentication(UsernamePasswordAuthenticationToken auth){
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}
