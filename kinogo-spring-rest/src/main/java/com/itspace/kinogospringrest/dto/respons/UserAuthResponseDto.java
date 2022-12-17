package com.itspace.kinogospringrest.dto.respons;

import com.itspace.kinogospringrest.dto.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAuthResponseDto {
    private String token;
    private UserDto user;
}
