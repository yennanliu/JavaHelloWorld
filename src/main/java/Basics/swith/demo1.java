package Basics.swith;

// https://www.runoob.com/java/java-switch-case.html

import org.junit.jupiter.api.Test;

/**
 * switch basic demo 1
 *
 * <p>Pattern :
 *
 * <p>switch(expression){ case value : //code break; //optional case value : //code break;
 * //optional //can have multiple case syntax ... default : //optional //code }
 */
public class demo1 {

  @Test
  public void test1() {

    char grade = 'C';

    switch (grade) {
      case 'A':
        System.out.println("excellent");
        break;

      case 'B':

      case 'C':
        System.out.println("SO SO");
        break;

      case 'D':
        System.out.println("qualified");
        break;
      default:
        System.out.println("unknown rank");
    }
    System.out.println(">>> your rank is " + grade);
  }

  @Test
  public void test2() {

    int i = 1;

    switch (i) {
      case 0:
        System.out.println("0");
        // NOTE !!! since there no break, so all the following case will be executed
      case 1:
        System.out.println("1");
      case 2:
        System.out.println("2");
      case 3:
        System.out.println("3");
      default:
        System.out.println("default");
    }
  }
}
