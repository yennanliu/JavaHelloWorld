package Advances.Annotation;

// https://www.youtube.com/watch?v=97y91HqV2Xo&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=504
// https://www.youtube.com/watch?v=X6tq0n0oizI&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=506
// https://www.youtube.com/watch?v=vsN71Vedujk&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=507
// https://www.youtube.com/watch?v=hKzyUbQaorM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=509

/**
 * Annotation demo 1
 *
 * <p>1) Annotation is a feature in JDK >= 5.0
 *
 * <p>2) Annotation is a special `sign` of the code, these sign can be compiled, overloaded, and
 * read during runtime. Developers can "insert" extra information to the code without any code
 * change via Annotation
 *
 * <p>3) Annotation can be used as `modifier` (e.g. public, private, static...); can be used in
 * package, class, constructor, method, variables, parameters... (these information are stored in
 * name=value)
 *
 * <p>4) use cases - auto documentation - check during compile
 * ( @Override, @Deprecated, @SuppressWarnings) - track code dependency, replace some config
 * functionalities
 *
 * <p>5) how to make user-defined-Annotation - refer @SuppressWarnings - step 1) init with
 * `public @interface` - step 2) define internal component, usually use `value` (e.g. String
 * value();) - we can aldo give default value to it (e.g. String value() default "hello";) - step 3)
 * if there is no arg in user-defined-Annotation, then it's just a "mark" purpose Annotation
 *
 * <p>6) JDK meta-Annotation : Annotation's Annotation - Retention : define life cycle of the
 * Annotation - Target - Documented - Inherited
 *
 * <p>7) Annotation new features since JDK 8
 *
 * <p>- repeatable annotation - step 1) add @Repeatable on MyAnnotation3 - step 2) use MyAnnotation3
 * in MyAnnotations
 *
 * <p>- Element type annotation - ElementType.TYPE_PARAMETER - ElementType.TYPE_USE - example :
 * https://github.com/yennanliu/JavaHelloWorld/blob/main/src/main/java/Advances/Annotation/demo2.java
 *
 * <p>8) Annotation used A LOT in framework. e.g. spring MVC, android dev ...
 */
public class demo1 {
  public static void main(String[] args) {}
}

/** demo 1 : basic annotation usage */
// @MyAnnotation(value="hello")  // if not default value in MyAnnotation, then we need give in a
// value
@MyAnnotation // if there's default value in MyAnnotation
class Person {
  // attr
  private String name;
  private int age;

  // constructor
  @MyAnnotation
  public Person() {}

  // method
  @MyAnnotation
  public void myPrint(String x) {
    System.out.println(x);
  }
}

/** demo 2 : use multiple annotations via array */
@MyAnnotations({@MyAnnotation3, @MyAnnotation3(value = "456")}) // before JDK 8
class Person2 {
  // attr
  private String name;
  private int age;
}

/** demo 3 : use multiple annotations via repeatable annotations */
// after JDK 8
@MyAnnotation3()
@MyAnnotation3(value = "lol")
class Person3 {
  // attr
  private String name;
  private int age;
}
