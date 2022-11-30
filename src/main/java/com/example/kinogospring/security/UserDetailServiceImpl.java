package com.example.kinogo-spring.security;

import com.example.kinogospring.entity.User;
import com.example.kinogospring.exception.UnauthorizedAccessException;
import com.example.kinogospring.repository.UserRepository;
import com.example.kinogospring.security.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> byEmail = userRepository.findByEmail(username);
        if (byEmail.isEmpty()) {
            throw new UsernameNotFoundException("username does not exists");
        }
        return new CurrentUser(byEmail.get());
    }

    public User getLoggedInUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            Optional<User> byEmail = userRepository.findByEmail(username);
            if (byEmail.isPresent()) {
                return byEmail.get();
            } else {
                throw new UsernameNotFoundException("username does not exists");
            }
        }
        throw new UnauthorizedAccessException("User is not logged in");

    }
}
