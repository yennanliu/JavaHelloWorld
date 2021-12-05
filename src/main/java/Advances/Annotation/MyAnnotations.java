package Advances.Annotation;

// https://www.youtube.com/watch?v=hKzyUbQaorM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=509

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 *  an array of Annotation for using multiple Annotations at once
 *
 */

@Target({ElementType.TYPE})
public @interface MyAnnotations {

    MyAnnotation3[] value();
}
