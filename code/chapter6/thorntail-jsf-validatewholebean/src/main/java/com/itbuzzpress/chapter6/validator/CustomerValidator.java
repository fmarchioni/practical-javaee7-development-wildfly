package com.itbuzzpress.chapter6.validator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomerValidator implements ConstraintValidator<ValidCustomer, Customer> {
    
    @Override
    public void initialize(ValidCustomer constraintAnnotation) {
        
    }
    
    @Override
    public boolean isValid(Customer value, ConstraintValidatorContext context) {
    	if (value.getEmail().endsWith(".com") && (value.getAge() < 50))
    		return true;
    	else
    		return false;
    			
        
    }
    
}
