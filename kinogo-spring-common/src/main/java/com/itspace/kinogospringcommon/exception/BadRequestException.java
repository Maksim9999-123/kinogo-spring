package com.itspace.kinogospringcommon.exception;

public class BadRequestException extends BasicException{
    public BadRequestException(ErrorHandler errorHandler) {
        super(errorHandler);
    }
}
