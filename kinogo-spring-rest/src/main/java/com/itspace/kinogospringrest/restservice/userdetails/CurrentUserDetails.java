package com.itspace.kinogospringrest.restservice.userdetails;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrentUserDetails {

    private int id;
    private String name;
    private List<SimpleGrantedAuthority> authorities;

}
