package com.itspace.kinogospringcommon.security;

import com.itspace.kinogospringcommon.exception.UnauthorizedAccessException;
import com.itspace.kinogospringcommon.exception.UserNotFoundException;
import com.itspace.kinogospringcommon.model.entity.User;
import com.itspace.kinogospringcommon.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.itspace.kinogospringcommon.exception.ErrorHandler.BAD_CREDENTIALS;
import static com.itspace.kinogospringcommon.exception.ErrorHandler.USER_NAME_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username){
        Optional<User> byEmail = userRepository.findByEmail(username);
        if (byEmail.isEmpty()) {
            throw new UserNotFoundException(USER_NAME_NOT_FOUND);
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
                throw new UserNotFoundException(USER_NAME_NOT_FOUND);
            }
        }
        throw new UnauthorizedAccessException(BAD_CREDENTIALS);

    }
}
