package com.itspace.kinogospringcommon.exception;

import lombok.Getter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;

@Getter
@Component
public class AppExceptionHandler implements AccessDeniedHandler {


    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {

        ErrorHandler handler = ErrorHandler.ACCESS_DENIED;

        AppError appError = new AppError(handler.getHttpStatus(),
                handler.getCode(),
                Instant.now(),
                handler.getMessage());
      //  response.setContentType();  --- set content type 'JSON' file ---
          response.setStatus(handler.getHttpStatus().value());
     //  response.getWriter().write(appError);   ---  for write exception on JSON file ---
    }
}
