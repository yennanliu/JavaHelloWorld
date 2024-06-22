package Advances.ObjectInputOutputFlow;

// https://www.youtube.com/watch?v=RUiVm1VkXB4&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=611

import java.io.*;
import org.junit.jupiter.api.Test;

/**
 *   Object Flow demo 1 : `serialization`, `deserialization` basic
 *
 *   1) ObjectInputStream, ObjectOutputStream
 *   2) purpose : can save, read, transform java instance <----> data flow
 *   3) serialization
 *   4) deserialization
 *   5) NOTE !!! : if we want a java class serializable, it needs below conditions (check Advances.ObjectInputOutputFlow.Person.java)
 */

public class demo1 {
    /**
     *  demo 1
     *  serialization : transform in-memory java instance into hard disk or send via internet
     *  will use ObjectOutputStream
     */
    @Test
    public void test1() {
        ObjectOutputStream oos = null;
        try{
            // step 1) create flow, instance
            oos = new ObjectOutputStream(new FileOutputStream("src/main/java/Advances/ObjectInputOutputFlow/output.txt"));

            // step 2) write data
            oos.writeObject(new String("London Tokyo NewYork"));

            // step 3) flush memory (so every write op will be reflected to output file)
            oos.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            // step 4) close resources
            if (oos != null){
                try{
                    oos.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     *  demo 2
     *  deserialization : transform hard disk / internet data to java instance
     *  will use ObjectInputStream
     */
    @Test
    public void test2() throws IOException, ClassNotFoundException {

        ObjectInputStream ois = null;

        try{

            // step 1)
            ois = new ObjectInputStream(new FileInputStream("src/main/java/Advances/ObjectInputOutputFlow/output.txt"));

            // step 2)
            Object obj = ois.readObject();
            // transform it into string, since we know it's string data type
            String str = (String) obj;
            System.out.println(str);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // step 3)
            if (ois != null){
                try{
                    ois.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
