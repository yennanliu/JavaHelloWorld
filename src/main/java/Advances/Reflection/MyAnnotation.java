package Advances.Reflection;

// https://www.youtube.com/watch?v=x6tmNMxMmZo&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=648

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "hello";
}
