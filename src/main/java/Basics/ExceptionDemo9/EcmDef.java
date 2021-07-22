package Basics.ExceptionDemo9;

// https://www.youtube.com/watch?v=aMplVyvmwYE&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=383

/**
 * Main testing class
 *
 *  Note :
 *    1) For compile exception -> We NEED TO DEAL WITH THEM
 *    2) For runtime exception -> Optional, we DON'T HAVE to catch with them
 */

public class EcmDef {
    public static void main(String[] args) {
        // run
        try{
            // get arg from CLI
            int i = Integer.parseInt(args[0]);
            int j = Integer.parseInt(args[1]);

            // divide
            int result = ecm(i, j);
            System.out.println("result = " + result);

        }catch (NumberFormatException e){
            System.out.println("i, j dtype is different");
            e.printStackTrace();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("args missing ! either i or j is not offered");
            e.printStackTrace();
        }catch (ArithmeticException e){
            System.out.println("divided by 0");
            e.printStackTrace();
        }catch (EcDef e){
            e.printStackTrace();
        }
    }

    public static int ecm(int i, int j) throws EcDef {
        if (i < 0 || j < 0){
            throw new EcDef("i or j is smaller than 0");
        }
        return  i / j;
    }
}
