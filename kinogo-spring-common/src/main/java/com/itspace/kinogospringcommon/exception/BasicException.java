package com.itspace.kinogospringcommon.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasicException extends RuntimeException{

    protected final ErrorHandler errorHandler;

    public BasicException(ErrorHandler  errorHandler){
        this.errorHandler = errorHandler;
    }
}
