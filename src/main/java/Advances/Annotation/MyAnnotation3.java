package Advances.Annotation;

// https://www.youtube.com/watch?v=hKzyUbQaorM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=509

import java.lang.annotation.*;

// NOTE : for enabling "repeatable annotations", we need to add `@Repeatable` annotation (as below)

@Repeatable(MyAnnotations.class)
@Target({ElementType.TYPE, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
public @interface MyAnnotation3 {

    String value() default "hello";
}
