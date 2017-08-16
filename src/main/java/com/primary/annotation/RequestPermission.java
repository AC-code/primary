package com.primary.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.primary.annotation.parser.RequestPermissionParser;

@Documented
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface RequestPermission {
	String role() default RequestPermissionParser.role_default;
	boolean isStrict() default false;
}
