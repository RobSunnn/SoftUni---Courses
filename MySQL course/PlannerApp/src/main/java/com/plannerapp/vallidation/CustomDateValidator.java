package com.plannerapp.vallidation;

import com.plannerapp.annotations.CustomDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class CustomDateValidator implements ConstraintValidator<CustomDate, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null && !value.isBlank()) {
            LocalDate parseDate = LocalDate.parse(value);
            return parseDate.isAfter(LocalDate.now());
        }

        return false;
    }
}
