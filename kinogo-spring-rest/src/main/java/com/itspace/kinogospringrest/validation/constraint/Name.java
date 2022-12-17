package com.itspace.kinogospringrest.validation.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.*;

/**
 * The {@code Name} annotation validate name fields
 *
 * @author  Maksim Aslanyan
 * version   1
 */

@NotBlank(message = "Can't be empty")
@Size(min = 3, max = 15, message = "Length should be between 3 and 15 characters!!!")
@Pattern(regexp = "^[A-Za-z]*$", message = "Should contain only letters!!")
@Documented
@Constraint(validatedBy = {})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Name {

    String message() default "Wrong name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload()default {};
}
