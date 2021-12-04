package Advances.Annotation;

// https://www.youtube.com/watch?v=97y91HqV2Xo&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=504
// https://www.youtube.com/watch?v=X6tq0n0oizI&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=506
// https://www.youtube.com/watch?v=vsN71Vedujk&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=507

/**
 *  Annotation demo 1
 *
 *  1) Annotation is a feature in JDK >= 5.0
 *
 *  2) Annotation is a special `sign` of the code, these sign
 *     can be compiled, overloaded, and read during runtime.
 *     Developers can "insert" extra information to the code
 *     without any code change via Annotation
 *
 *  3) Annotation can be used  as `modifier` (e.g. public, private, static...);
 *     can be used in package, class, constructor, method, variables, parameters...
 *     (these information are stored in name=value)
 *
 *  4) use cases
 *     - auto documentation
 *     - check during compile ( @Override, @Deprecated, @SuppressWarnings)
 *     - track code dependency, replace some config functionalities
 *
 *  5) how to make user-defined-Annotation
 *      - refer @SuppressWarnings
 *      - step 1) init with `public @interface`
 *      - step 2) define internal component, usually use `value` (e.g. String value();)
 *          - we can aldo give default value to it (e.g. String value() default "hello";)
 *      - step 3) if there is no arg in user-defined-Annotation, then it's just a "mark" purpose Annotation
 *
 *  6) JDK meta-Annotation : Annotation's Annotation
 *      - Retention : define life cycle of the Annotation
 *      - Target
 *      - Documented
 *      - Inherited
 */

public class demo1 {
}

//@MyAnnotation(value="hello")  // if not default value in MyAnnotation, then we need give in a value
@MyAnnotation // if there's default value in MyAnnotation
class Person{
    // attr
    private String name;
    private int age;

    // constructor
    @MyAnnotation
    public Person(){

    }

    // method
    @MyAnnotation
    public void myPrint(String x){
        System.out.println(x);
    }

}