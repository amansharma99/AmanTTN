package com.Bootcamp2020Project.Project.Validators;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword,String> {
@Override
public void initialize(ValidPassword constraintAnnotation) {

        }

@Override
public boolean isValid(String value, ConstraintValidatorContext context) {

        return false;
        }
        }

