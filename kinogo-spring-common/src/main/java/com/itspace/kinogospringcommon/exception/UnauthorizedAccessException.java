package com.itspace.kinogospringcommon.exception;

public class UnauthorizedAccessException extends BasicException {

    public UnauthorizedAccessException(ErrorHandler errorHandler) {
        super(errorHandler);
    }
}
