package com.itspace.kinogospringrest.validation.constraint;

import com.itspace.kinogospringrest.validation.NullOrNotEmptyListValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * The {@code ValidVideo} annotation validate Null or not empty list field
 *
 * @author  Maksim Aslanyan
 * version   1
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NullOrNotEmptyListValidator.class)
public @interface NullOrNotEmptyList {

    String message() default "{This field can`t be null or empty}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
