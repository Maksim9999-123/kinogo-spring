package com.itspace.kinogospringrest.validation;

import com.itspace.kinogospringrest.validation.constraint.Password;
import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code UserPasswordValidator} class wraps for validate password field
 * and size,
 * class implements {@code ConstraintValidator} for create a custom constraint
 *
 * @author  Maksim Aslanyan
 * version   1
 */

public class UserPasswordValidator implements ConstraintValidator<Password, String> {

    @Override
    public void initialize(Password constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null || value.length() == 0) {
            return true;
        }

        List<Rule> rules = new ArrayList<>();
        rules.add(new LengthRule(10, 20));
        rules.add(new CharacterRule(EnglishCharacterData.UpperCase,1));
        rules.add(new CharacterRule(EnglishCharacterData.LowerCase,1));
        rules.add(new CharacterRule(EnglishCharacterData.Digit,1));
        rules.add(new WhitespaceRule());
        PasswordValidator passwordValidator = new PasswordValidator(rules);
        RuleResult result = passwordValidator.validate(new PasswordData(value));

        return result.isValid();
    }
}
