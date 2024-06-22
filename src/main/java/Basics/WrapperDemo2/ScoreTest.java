package Basics.WrapperDemo2;

// https://www.youtube.com/watch?v=TO4Yo8C4aWM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=309

import java.util.Scanner;
import java.util.Vector;

/**
 * Do student score transform via Vector (replace Array) And get the scores by level (Rank A, B ...)
 *
 * <p>Note : Different from Array, length of Vector is dynamic
 *
 * <p>1) Vector v = new Vector(); 2) v.addElement(Object obj); 3) index starts from 0 4) get size :
 * v.size();
 */
public class ScoreTest {

  public static void main(String[] args) {
    // step 1) get score via CLI via Scanner
    Scanner scan = new Scanner(System.in);

    // step 2) instantiate Vector instance
    Vector v = new Vector();

    int maxScore = 0;

    // step 3) for loop ( for (;;) ) or while (true) insert data
    for (; ; ) {
      System.out.println("plz input student score (minus means exit)");
      int score = scan.nextInt();

      if (score < 0) {
        break;
      }

      if (score > 100) {
        System.out.println("invalid input, plz input again");
        continue;
      }

      // step 3.1) add score to Vector
      // before JDK 5.0
      Integer inScore = new Integer(score);
      v.addElement(inScore); // polymorphism

      // after JDK 5.0
      // v.addElement(score); // autoboxing

      // step 4) get the highest score
      if (maxScore < score) {
        maxScore = score;
      }
    }

    // step 5) go through Vector for getting each student's score, and compare with highest and get
    // rank
    char level;
    for (int i = 0; i < v.size(); i++) {
      // get the element (score)
      Object obj = v.elementAt(i);

      // before JDK 5.0
      Integer inScore = (Integer) obj;
      int score = inScore.intValue(); // transform to basic type

      // after JDK 5.0
      //            int _score = (int) obj;
      //            if (maxScore - _score <= 10){
      //              ....
      //            } ...

      if (maxScore - score <= 10) {
        level = 'A';
      } else if (maxScore - score <= 20) {
        level = 'B';
      } else if (maxScore - score <= 30) {
        level = 'C';
      } else {
        level = 'D';
      }

      System.out.println("student : " + i + " | score = " + score + " | level = " + level);
    }
  }
}
