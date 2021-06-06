package Basics.EqualsDemo1;

// https://www.youtube.com/watch?v=zcP75HnjiAE&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=295
// https://github.com/yennanliu/JavaHelloWorld/blob/main/src/main/java/Basics/EqualsDemo1/demo1.java

/**
 *   Difference between == and equals()
 *
 *   1) ==
 *   // https://github.com/yennanliu/JavaHelloWorld/blob/main/src/main/java/Basics/EqualsDemo1/demo1.java
 *   ....
 *
 *   2) Equals
 *      2-1) Equals is a method, NOT operator
 *      2-2) Equals can ONLY be used in Reference data type
 *
 *
 */

public class demo2 {
    public static void main(String[] args){
        // example 1
        Customer cust1 = new Customer("tom", 21);
        Customer cust2 = new Customer("tom", 21);

        /**
         *
         * Note : Object's equal -> is SAME AS "=="
         *      -> so it's comparing address (since cust1 is reference data type)
         *
         * 1) Object's equal :
         *    1-1) class
         *      // java.lang.Object @Contract(value = "null -> false", pure = true)
         *      // public boolean equals(Object obj)
         *    1-2) actual logic
         *      //     public boolean equals(Object obj) {
         *      //        return (this == obj);
         *      //    }
         */
        System.out.println(cust1.equals(cust2)); //false

        System.out.println("==============");

        String str1 = new String("java");
        String str2 = new String("java");

        /**
         *
         *  NOTE : the equals in String are actually overridden,
         *     -> so it is comparing the value, but DIFFERENT FROM the Object's equals
         *
         * 1) String's equal :
         *     1-1) class
         *        // java.lang.String @Contract(value = "null -> false", pure = true)
         *        // public boolean equals(@Nullable Object anObject)
         */
        System.out.println(str1.equals(str2)); //true
    }

}
