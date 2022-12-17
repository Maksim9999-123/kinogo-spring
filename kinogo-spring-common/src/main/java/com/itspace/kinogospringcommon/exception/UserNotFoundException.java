package com.itspace.kinogospringcommon.exception;



public class UserNotFoundException extends BasicException{

    public UserNotFoundException(ErrorHandler errorHandler) {
        super(errorHandler);
    }
}
