package Advances.Annotation;

// https://www.youtube.com/watch?v=vsN71Vedujk&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=507

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation2 {
    String value() default "123";
}
