package com.plannerapp.annotations;

import com.plannerapp.vallidation.CustomDateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomDateValidator.class )
public @interface CustomDate {

    String message() default "Date must be in the future!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
