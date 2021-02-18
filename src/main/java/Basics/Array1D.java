package Basics;

// https://www.youtube.com/watch?v=nzYZD5-TaUg&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=144

public class Array1D {
    public static void main(String[] args){
        System.out.println("Array1D ...");

        /* every valuable in the method is "local" valuable (method = main in this example)*/
        /* "local" valuable will be put into the "Stack" */
        /* Any object from "new" will be put into the "Heap" */

        // let's define some array!
        Integer[] arr1  = new Integer[]{1,2,3};

        System.out.println(arr1);
        System.out.println(arr1[0]);
        System.out.println(arr1[1]);

        for (int j = 0; j < arr1.length; j++){
            System.out.println(j);
        }

        System.out.println("---------------------");

        String[] arr2 = new String[4];
        System.out.println(arr2);
        System.out.println(arr2[0]);
        System.out.println(arr2[1]);
        arr2[0] = "tom";
        System.out.println(arr2[0]);

        System.out.println("---------------------");

        Double[] arr3 = new Double[3];
        arr3[0] = 0.01;
        arr3[1] = 1.3;
        arr3[2] = 99.99;
        System.out.println(arr3);
    }
}
