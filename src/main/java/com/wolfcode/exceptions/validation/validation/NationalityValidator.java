package com.wolfcode.exceptions.validation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class NationalityValidator implements ConstraintValidator<ValidateNationality, String> {
    @Override
    public boolean isValid(String nationality, ConstraintValidatorContext constraintValidatorContext) {
        List<String> countries = Arrays.asList("ALGERIA", "ANGOLA", "NIGERIA", "SOUTH AFRICA", "EGYPT",
                "KENYA", "MOROCCO", "GHANA", "ETHIOPIA", "TANZANIA",
                "UNITED KINGDOM", "FRANCE", "ITALY", "SPAIN",
                "POLAND", "NETHERLANDS", "BELGIUM", "SWEDEN", "SWITZERLAND");

        return countries.contains(nationality);
    }
}
