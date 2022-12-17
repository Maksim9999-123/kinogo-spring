package com.itspace.kinogospringcommon.exception;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AppError {

    @Schema(description = "Http response status", example = "CONFLICT")
    private HttpStatus status;

    @Schema(description = "The exception description", example = "4121")
    private Integer errorCode;

    @Schema(description = "Timestamp showing when the error occurred")
    private Instant timestamp;

    @Schema(
            description = "Error message",
            example = "There is an user registered with such an email!")
    private String message;

}
