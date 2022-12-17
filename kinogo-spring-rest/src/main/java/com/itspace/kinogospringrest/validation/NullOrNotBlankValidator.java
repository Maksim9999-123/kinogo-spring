package com.itspace.kinogospringrest.validation;

import com.itspace.kinogospringrest.validation.constraint.NullOrNotBlank;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * The {@code NotNullOrNotBlankValidator} class wraps for validate not null or not blank fields
 * and size,
 * class implements {@code ConstraintValidator} for create a custom constraint
 *
 * @author  Maksim Aslanyan
 * version   1
 */
public class NullOrNotBlankValidator implements ConstraintValidator<NullOrNotBlank, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return !value.isEmpty();
    }
}
