package fundamentals.custom_annotation.annotation.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Spring validation framework can use this custom validation
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Constraint(validatedBy = CustomValidator.class)
public @interface ValidMedalCount {
    public String message() default "Invalid medal count. Value needs to be less than 100";


    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
