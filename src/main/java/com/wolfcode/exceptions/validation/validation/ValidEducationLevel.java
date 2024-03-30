package com.wolfcode.exceptions.validation.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EducationLevelValidator.class)
public @interface ValidEducationLevel {

    public String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
