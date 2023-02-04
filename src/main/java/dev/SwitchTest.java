package dev;

import org.junit.jupiter.api.Test;

/**
 *
 *  https://youtu.be/ueC_C_0o7dY?t=714
 *
 */
public class SwitchTest {

    @Test
    public void test1(){

        String input1 = "wefewew";
        System.out.println(myFunc(input1));

        System.out.println();

        String input2 = "123";
        System.out.println(myFunc(input2));
    }

    public String myFunc(String input){

        System.out.println("input = " + input);
        String res = "others";
        switch (input){
            case "123":
                res = "123";
            case "yes":
                res = "yes";
        }
        return res;
    }

}
