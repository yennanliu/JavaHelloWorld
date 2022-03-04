package Advances.ObjectInputOutputFlow;

// https://www.youtube.com/watch?v=F7FPaVlGhhc&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=611

/**
 *   Object Flow demo 2 : `serialization`, `deserialization` with custom java class
 *
 *   NOTE !!! : if we want a java class serializable, it needs below conditions (check Advances.ObjectInputOutputFlow.Person.java)
 */

import org.junit.jupiter.api.Test;

import java.io.*;

public class demo2 {

    @Test
    public void test1() {
        ObjectOutputStream oos = null;
        try{
            // step 1) create flow, instance
            oos = new ObjectOutputStream(new FileOutputStream("src/main/java/Advances/ObjectInputOutputFlow/output2.txt"));

            // step 2) write data
            oos.writeObject(new String("London Tokyo NewYork"));

            // step 3) flush memory (so every write op will be reflected to output file)
            oos.flush();

            // NOTE : we have to make Person class serializable, or will face "java.io.NotSerializableException: Advances.ObjectInputOutputFlow.Person" exception
            oos.writeObject(new Person("amy", 17));
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
            ois = new ObjectInputStream(new FileInputStream("src/main/java/Advances/ObjectInputOutputFlow/output2.txt"));

            // step 2)
            Object obj = ois.readObject();

            // NOTE : read data type should align with write data type
            // read string : transform it into string, since we know it's string data type
            String str = (String) obj;
            System.out.println(str);

            // read Person
            Person p = (Person) ois.readObject();
            System.out.println(p); //Person{name='amy', age=17}

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
