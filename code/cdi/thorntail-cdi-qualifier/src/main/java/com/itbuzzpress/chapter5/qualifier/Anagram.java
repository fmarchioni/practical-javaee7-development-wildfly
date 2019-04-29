 

package com.itbuzzpress.chapter5.qualifier;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import com.itbuzzpress.chapter5.enums.Language;

@Qualifier
@Retention(RUNTIME)
@Target({ FIELD, TYPE, METHOD })

public @interface Anagram {
	Language value();

}