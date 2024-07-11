package Basics.EqualsDemo1;

// https://www.youtube.com/watch?v=zcP75HnjiAE&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=295
// https://github.com/yennanliu/JavaHelloWorld/blob/main/src/main/java/Basics/EqualsDemo1/demo1.java

import java.util.Date;

/**
 * Difference between == and equals()
 *
 * <p>1) == //
 * https://github.com/yennanliu/JavaHelloWorld/blob/main/src/main/java/Basics/EqualsDemo1/demo1.java
 * ....
 *
 * <p>2) Equals 2-1) Equals is a method, NOT operator 2-2) Equals can ONLY be used in Reference data
 * type 2-3) in Object, definition of equals(): // public boolean equals(Object obj) { // return
 * (this == obj);
 *
 * <p>-> same equals in Object is SAME as == -> compare the ADDRESS IN MEMORY ( or if the SAME
 * INSTANCE)
 *
 * <p>2-4) For some types (class) such as String, Date, File -> They've overridden the equals method
 * -> SO compare if "content" (attr: such as value..) are the SAME; but NOT address - e.g. for
 * Customer, content : name, age
 *
 * <p>2-5) In general cases, we want equals to compare "content" rather than address -> so we need
 * to OVERWRITE the equals method
 */
public class demo2 {
  public static void main(String[] args) {
    // example 1
    Customer cust1 = new Customer("tom", 21);
    Customer cust2 = new Customer("tom", 21);

    /**
     * Note : Object's equal -> is SAME AS "==" -> so it's comparing address (since cust1 is
     * reference data type)
     *
     * <p>1) Object's equal : 1-1) class // java.lang.Object @Contract(value = "null -> false", pure
     * = true) // public boolean equals(Object obj) 1-2) actual logic // public boolean
     * equals(Object obj) { // return (this == obj); // }
     */
    System.out.println(
        cust1.equals(cust2)); // false, (but will be true if we OVERWRITE the equals method)

    System.out.println("==============");

    // example 2
    String str1 = "java";
    String str2 = "java";

    /**
     * NOTE : the equals in String are actually overridden, -> so it is comparing the value, but
     * DIFFERENT FROM the Object's equals
     *
     * <p>1) String's equal : 1-1) class // java.lang.String @Contract(value = "null -> false", pure
     * = true) // public boolean equals(@Nullable Object anObject)
     */
    System.out.println(str1.equals(str2)); // true

    System.out.println("==============");

    // example 3
    Date date1 = new Date(5435435L);
    Date date2 = new Date(5435435L);

    System.out.println(date1.equals(date2)); // true
  }
}
