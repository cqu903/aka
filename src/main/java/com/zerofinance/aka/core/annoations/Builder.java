package com.zerofinance.aka.core.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.zerofinance.aka.core.utils.CodeBuilder;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Builder {
	
	Class<? extends CodeBuilder> value();
}
