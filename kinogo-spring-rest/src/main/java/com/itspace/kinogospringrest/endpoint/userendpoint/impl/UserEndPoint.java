package com.itspace.kinogospringrest.endpoint.userendpoint.impl;


import com.itspace.kinogospringcommon.model.entity.User;
import com.itspace.kinogospringrest.dto.user.ChangePasswordRequestDto;
import com.itspace.kinogospringrest.dto.user.EditUserDto;
import com.itspace.kinogospringrest.endpoint.userendpoint.UserApp;
import com.itspace.kinogospringrest.restservice.user.impl.UserServiceImpl;
import com.itspace.kinogospringrest.restservice.userdetails.CurrentUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * REST controller user connected requestst.
 *
 * @author Maksim Aslanyan
 * @version 1.0
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserEndPoint implements UserApp {

    private final UserServiceImpl userService;

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('resource_write')")
    public ResponseEntity<User> getById(@PathVariable("id") int id,
                                        @AuthenticationPrincipal UserDetails user) {

        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("#user.id == #id")
    public ResponseEntity<User> editUser(@PathVariable("id") int id,
                                         @AuthenticationPrincipal CurrentUserDetails user,
                                         @Valid @RequestBody EditUserDto editUserDto) {
        return ResponseEntity.ok(userService.edit(id, editUserDto));
    }

    @GetMapping("/my/cabinet")
    public ResponseEntity<User> getCurrentUser() {
        return ResponseEntity.ok(userService.getCurrentUser());
    }

    @PutMapping("/password/change")
    public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePasswordRequestDto changePasswordRequestDto) {
        userService.changePassword(changePasswordRequestDto);
        return ResponseEntity.ok().build();
    }

}
