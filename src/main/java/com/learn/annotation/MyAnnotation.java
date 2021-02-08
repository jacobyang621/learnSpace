package com.learn.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value ={ ElementType.METHOD,ElementType.TYPE})
public @interface MyAnnotation {

}
