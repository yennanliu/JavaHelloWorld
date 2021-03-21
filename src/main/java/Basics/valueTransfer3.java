package Basics;

// https://www.youtube.com/watch?v=Ty2ILPjUttE&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=220

public class valueTransfer3 {
    public static void main(String[] args){
        // run
        String s1 = "hello";
        valueTransfer3 test = new valueTransfer3();
        test.change_(s1);

        /*
         * Note :
         * 1) String s1 = "hello"; is not a "basic" value, but is a "reference" value
         *               -> String is not in "stack", but in the "constant string" space
         * 2) since s1 is a "reference" value => s1 is actually pointing to the address in "constant string" space
         *               -> so, when method (change_) run, it will make a new address in "constant string" space  with value = "hi ~~~~"
         * 3) so outside the method (change_) the s1 still keeps its value as "hello"
         */

        System.out.println("s1 =  " + s1); // hello
    }

    public void change_(String s){
        s = "hi ~~~~";
    }
}
