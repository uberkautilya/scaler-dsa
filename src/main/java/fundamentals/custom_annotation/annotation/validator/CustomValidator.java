package fundamentals.custom_annotation.annotation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Custom validator would work with only rest @Valid mechanism/ Spring validation framework
 */
public class CustomValidator implements ConstraintValidator<ValidMedalCount, Integer> {

    @Override
    public boolean isValid(Integer count, ConstraintValidatorContext context) {
        return count < 100;
    }
}
