package org.example.validate_form_dang_ky.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.Period;

public class CheckAge implements ConstraintValidator<ValidAge, LocalDate> {

    @Override
    public boolean isValid(LocalDate dob, ConstraintValidatorContext constraintValidatorContext) {
        if (dob == null){
            return false;
        }
        return Period.between(dob, LocalDate.now()).getYears() >= 18;
    }
}
