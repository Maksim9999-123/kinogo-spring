package com.itspace.kinogospringrest.validation;

import com.itspace.kinogospringrest.validation.constraint.ValidVideo;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * The {@code NotNullVideo} class wraps for validate video extension
 * and size,
 * class implements {@code ConstraintValidator} for create a custom constraint
 *
 * @author  Maksim Aslanyan
 * version   1
 */


public class NotNullVideo implements ConstraintValidator<ValidVideo, MultipartFile> {


    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext constraintValidatorContext) {
        return file==null|| !file.isEmpty();
    }
}
