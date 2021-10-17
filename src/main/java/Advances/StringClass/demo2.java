package Advances.StringClass;

// https://www.youtube.com/watch?v=aAKyixOtfYc&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=452
// https://www.youtube.com/watch?v=okWPvEHmi7w&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=453

import org.junit.jupiter.api.Test;

/**
 *  String class demo 2 : string instantiate example
 *
 *  ref :
 *      - https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/string_vs_new_string.png
 *
 *
 *  method 1) via literal:
 *      - String str1 = "abc;
 *      - as string constant, as shared value for most cases
 *
 *  method 2) via new + constructor:
 *      - String str2 = new String("abc");
 *      - as string (non constant)
 *      - NOTE*** : if there is a variable (e.g. s1) then this value is storage in stack space, but not constant pool space
 *         - example : String s5 = s1 + "hadoop";
 */

public class demo2 {
    /**
     *
     */
    @Test
    public void test1(){

        // https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/string_vs_new_string2.png

        // method 1) via literal:
        // s1, s2 are defined in java's string constant pool
        String s1 = "scala";
        String s2 = "scala";

        // method 2) via new + constructor:
        // s3, s3 are defined in address in java's stack space
        String s3 = new String("scala");
        String s4 = new String("scala");


        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s1 == s4); // false
        System.out.println(s3 == s4); // false

        System.out.println("===============");

        // https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/string_vs_new_string3.png

        Person p1 = new Person("tim", 17);
        Person p2 = new Person("tim", 17);

        System.out.println(p1.name.equals(p2.name)); // true
        System.out.println(p1.name == p2.name); // true

        p1.name = "terry";
        System.out.println(p2.name); // tim
    }

    @Test
    public void test2(){
        /**
         *  1) concatenation of constant and constant -> still in constant pool
         *  2) concatenation of variable and constant -> as `new`, so in stack space
         */

        // https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/string_vs_new_string4.png

        String s1 = "java";
        String s2 = "hadoop";

        String s3 = "javahadoop";  // literal value
        String s4 = "java" + "hadoop"; // concatenation of 2 literal values is still literal value
        String s5 = s1 + "hadoop"; // NOTE*** : if there is a variable (e.g. s1) then this value is storage in stack space, but not constant pool space
        String s6 = "java" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4); // true
        System.out.println(s3 == s5); // false
        System.out.println(s3 == s6); // false
        System.out.println(s3 == s7); // false
        System.out.println(s5 == s6); // false
        System.out.println(s5 == s7); // false
        System.out.println(s6 == s7); // false

        String s8 = s5.intern();  // return value (s8) is in constant pool (the already existed value : "java")
        System.out.println(s3 == s8); // true
    }

    @Test
    public void test3(){
        // equals `this.value = new char[0];`
        String s1_ = new String();

        // this.value = original.value;
        String str = "helo";
        String s2_ = new String(str); // (String str);

        // this.value = Arrays.copyOf(value, value.length);
        //String s3 = new String(char[] a);

        //String s4 = new String(char[] a, int startIndex, int count);
    }
}
