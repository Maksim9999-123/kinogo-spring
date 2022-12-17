package com.itspace.kinogospringrest.validation;

import com.itspace.kinogospringrest.validation.constraint.NullOrNotEmptyList;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * The {@code NotNullOrNotEmptyListValidator} class wraps for validate list fields,
 *
 * class implements {@code ConstraintValidator} for create a custom constraint
 *
 * @author  Maksim Aslanyan
 * version   1
 */
public class NullOrNotEmptyListValidator implements ConstraintValidator<NullOrNotEmptyList, List<String>> {


    @Override
    public boolean isValid(List<String> strings, ConstraintValidatorContext constraintValidatorContext) {
        return strings == null||!strings.isEmpty();
    }
}
