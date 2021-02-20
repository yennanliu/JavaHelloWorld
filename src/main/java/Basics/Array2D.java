package Basics;

// https://www.youtube.com/watch?v=emfkspXXhds&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=147

public class Array2D {
    public static void main(String[] args){

        // initiate (static)
        int[][] arr1 = new int[][]{{1,2,3}, {4,5,6}};

        // initiate (dynamic)
        int[][] arr2 = new int[3][2];
        int[][] arr3 = new int[3][];

        System.out.println(arr1);
        System.out.println(arr1[0][0]);
        System.out.println(arr1[0][1]);

        System.out.println("------------");

        System.out.println(arr2);
        System.out.println(arr2[0][0]); // 0
        System.out.println(arr2[1][1]); // 0

        System.out.println("------------");

        System.out.println(arr3);
        arr3[1] = new int[4];
        System.out.println(arr3[1][0]);
    }
}
