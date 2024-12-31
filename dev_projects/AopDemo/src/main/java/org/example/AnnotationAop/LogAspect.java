package org.example.AnnotationAop;

// https://youtu.be/WjEWMZlpiRo?si=LaSyN_gqeoOYean0&t=132

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/** class for AOP */

@Component // IOC, managed by spring container
@Aspect // aspect class
public class LogAspect {}
