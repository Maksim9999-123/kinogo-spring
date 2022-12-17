package com.itspace.kinogospringrest.endpoint.userendpoint;

import com.itspace.kinogospringcommon.model.entity.User;
import com.itspace.kinogospringcommon.service.UserService;
import com.itspace.kinogospringrest.dto.respons.UserAuthResponseDto;
import com.itspace.kinogospringrest.mapper.UserMapper;
import com.itspace.kinogospringrest.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")

public class AuthUser {
    private final UserService userService;
    private final UserMapper userMapper;


    private final JwtTokenUtil jwtTokenUtil;

    private final PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody CreateUserDto createUserDto) throws MessagingException {
        Optional<User> existingUser = userService.findByEmail(createUserDto.getEmail());
        if(existingUser.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        User user = userMapper.map(createUserDto);
        return ResponseEntity.ok(userMapper.map(userService.save(user)));
    }

    @PostMapping("/auth")
    public ResponseEntity<?> auth(@RequestBody UserAuthDto userAuthDto){
        Optional<User> byEmail = userService.findByEmail(userAuthDto.getEmail());
        if(byEmail.isPresent()){
            User user = byEmail.get();
            if(passwordEncoder.matches(userAuthDto.getPassword(), user.getPassword())){
                return ResponseEntity.ok(UserAuthResponseDto.builder()
                        .token(jwtTokenUtil.generateToken(userAuthDto.getEmail()))
                        .user(userMapper.map(user))
                        .build());
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
