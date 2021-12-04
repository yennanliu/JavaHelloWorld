package Advances.Annotation;

// https://www.youtube.com/watch?v=X6tq0n0oizI&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=506

public @interface MyAnnotation {

    String value() default "hello";
}
