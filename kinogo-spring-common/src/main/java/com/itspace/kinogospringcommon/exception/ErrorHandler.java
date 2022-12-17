package com.itspace.kinogospringcommon.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

/**
 * Exception Handler
 *
 * @author Maksim Aslanyan
 */

@RequiredArgsConstructor
@Getter
public enum ErrorHandler {

    PROVIDED_WRONG_PASSWORD(401, BAD_REQUEST, "Provided Wrong Password In Change Password Request"),
    INVALID_ROLE(407, BAD_REQUEST, "Can't Parse String Value To Role Enum"),



    REFRESH_TOKEN_EXPIRED(412, BAD_REQUEST, "Expired Refresh Token"),
    REFRESH_TOKEN_INVALID(413, BAD_REQUEST, "Invalid Refresh Token"),


    BAD_CREDENTIALS(401, UNAUTHORIZED, "Bad Credentials"),
    NOT_ACTIVE_ACCOUNT(415, UNAUTHORIZED, "User Email Is Not Verified"),

    ACCESS_DENIED(431, FORBIDDEN, "Permission Denied To Requested Resource"),

    CONFIRM_TOKEN_NOT_FOUND(441, NOT_FOUND, "Confirmation Token Not Found"),

    CAST_CREW_NOT_FOUND(4004, NOT_FOUND, "There Is Cast & Crew not found Id"),
    GENRE_NOT_FOUND(404, NOT_FOUND, "There Is No Genre not found Id"),
    IMAGE_NOT_FOUND(445, NOT_FOUND, "There Is No Image For The Given User"),
    MOVIE_NOT_FOUND(12, NOT_FOUND, "Movie  Not Found"),

    PROVIDED_SAME_PASSWORD(55, CONFLICT, "Provided The Same Password In Change Password Request"),
    USER_ALREADY_EXIST_WITH_EMAIL(21, CONFLICT, "There Is a User Registered With Such Email"),
    USER_NOT_FOUND(22, NOT_FOUND, "There Is No User With Such Id"),
    USER_NAME_NOT_FOUND(22, NOT_FOUND, "There Is No User With Such Id"),


    INVALID_IMAGE_FORMAT(121, PRECONDITION_FAILED, "Cannot Upload The Image"),
    INVALID_IMAGE_SIZE(
            122, PRECONDITION_FAILED, "Image Has Smaller Size Than It's Required (600x600)"),
    INVALID_FILE_SIZE(123, PRECONDITION_FAILED, "File Size Should Be Between 70KB and 30MB"),
    INVALID_IMAGE_EXTENSION(
            124, PRECONDITION_FAILED, "The Extension Of The Image Should Be Either 'jpg/jpeg' or 'png'"),

    SEND_EMAIL_FAILED(30, INTERNAL_SERVER_ERROR, "Failed To Send An Email");


    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;
}
