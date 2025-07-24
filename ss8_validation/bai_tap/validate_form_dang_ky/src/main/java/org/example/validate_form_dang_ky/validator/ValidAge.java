package org.example.validate_form_dang_ky.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckAge.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ValidAge {
    String message() default "Phải từ 18 trở lên";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
