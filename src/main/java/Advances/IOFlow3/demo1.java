package Advances.IOFlow3;

// https://www.youtube.com/watch?v=B86dDjwNroY&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=602

/**
 * IOFlow3 demo 1: standard input and output stream
 *
 * <p>1) System.in, System.out (輸入流, 輸出流) - InputStream, OutputStream 2) PrintStream (打印流) 3) data
 * flow
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class demo1 {

  /**
   * demo 1: System.in, System.out 1) System.in : input via keyboard System.out : output via
   * terminal
   *
   * <p>2) we can use System.setIn(InputStream is), System.setOut(OutputStream os) to modify input,
   * output stream
   *
   * <p>3) (below example) : write a program that will transform input to upper case (if alphabet),
   * quit the program if receive "e" or "exit"
   */

  // intellJ doesn't support unit test input flow, so here we use main method instead
  public static void main(String[] args) {
    InputStreamReader isr = null;
    BufferedReader br = null;
    try {
      isr = new InputStreamReader(System.in);
      br = new BufferedReader(isr);

      while (true) {
        System.out.println("plz input string");
        String data = br.readLine();
        if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
          // System.exit(0);
          System.out.println("program end");
          break;
        }
        String upperCase = data.toUpperCase();
        System.out.println(upperCase);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // close resources
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  //    @Test
  //    public void test1(){
  //
  //        InputStreamReader isr = null;
  //        BufferedReader br = null;
  //        try{
  //            isr = new InputStreamReader(System.in);
  //            br = new BufferedReader(isr);
  //
  //            while (true){
  //                System.out.println("plz input string");
  //                String data = br.readLine();
  //                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)){
  //                    //System.exit(0);
  //                    System.out.println("program end");
  //                    break;
  //                }
  //                String upperCase = data.toUpperCase();
  //                System.out.println(upperCase);
  //            }
  //        }catch (Exception e){
  //            e.printStackTrace();
  //        }finally {
  //            // close resources
  //            if (br != null){
  //                try{
  //                    br.close();
  //                }catch (IOException e){
  //                    e.printStackTrace();
  //                }
  //            }
  //        }
  //    }

}
