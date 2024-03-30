package com.wolfcode.exceptions.validation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class EducationLevelValidator implements ConstraintValidator<ValidEducationLevel, String> {
    @Override
    public boolean isValid(String levelOfStudy, ConstraintValidatorContext constraintValidatorContext) {
        List<String> educationLevel = Arrays.asList("primary", "secondary", "university");
        return educationLevel.contains(levelOfStudy);
    }
}
