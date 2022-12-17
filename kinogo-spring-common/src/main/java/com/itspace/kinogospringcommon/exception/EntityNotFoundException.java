package com.itspace.kinogospringcommon.exception;

public class EntityNotFoundException extends BasicException{
    public EntityNotFoundException(ErrorHandler errorHandler) {
        super(errorHandler);
    }
}
