package com.itspace.kinogospringrest.validation.constraint;

import com.itspace.kinogospringrest.validation.NullOrNotBlankValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * The {@code NullOrNotBlank} annotation validate not null and not blank fields
 *
 * @author  Maksim Aslanyan
 * version   1
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NullOrNotBlankValidator.class)
public @interface NullOrNotBlank {

    String message() default "{Field can be null or empty}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
