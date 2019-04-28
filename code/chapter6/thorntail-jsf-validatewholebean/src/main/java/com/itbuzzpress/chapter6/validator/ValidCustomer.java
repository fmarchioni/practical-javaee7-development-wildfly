package com.itbuzzpress.chapter6.validator;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = {CustomerValidator.class})
@Documented
@Target(TYPE)
@Retention(RUNTIME)
public @interface ValidCustomer {

    String message() default "This customer does not meet our requirements!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
