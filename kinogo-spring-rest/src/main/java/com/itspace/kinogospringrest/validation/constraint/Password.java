package com.itspace.kinogospringrest.validation.constraint;

import com.itspace.kinogospringrest.validation.UserPasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * The {@code Password} annotation validate password field
 *
 * @author  Maksim Aslanyan
 * version   1
 */

@Documented
@Constraint(validatedBy = UserPasswordValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {

    String message() default """
            Wrong password!! Password should have 10 to 20 characters and 
            uppercase characters, lowercase characters and digits,
            WITHOUT withespace! """;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
