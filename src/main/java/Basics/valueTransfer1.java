package Basics;

// plz compare with valueTransfer2

import java.util.Arrays;

public class valueTransfer1 {
    public static void main(String[] args){
        // run
        int m = 1;
        int n = 3;
        System.out.println("m = " + m + ", n = " + n);

        System.out.println("--------------");

        valueTransfer1 test = new valueTransfer1();
        test.swap_1(m, n);
        // should be the same (still m=1, n=3)
        // since in here, m=1, n=3 are "basic value", so m, n points to the actual value here (rather than some place in heap space)
        // and the m, n inside swap_1 method are actually in "stack" space, so they r not in the heap space, as the one we defined at beginning
        // so the swap op is not working here
        System.out.println("m = " + m + ", n = " + n);

        System.out.println("--------------");

        int arr[] = {1,3};
        test.swap_1_fixed(arr);
        for (int j = 0; j < arr.length ; j ++){
            System.out.println(arr[j]);
        }
    }

    public void swap_1(int m, int n) {
        // do the swap in place
        int tmp_ = m;
        m = n;
        n = tmp_;
    }

    // let's define a "fixed" version here
    public void swap_1_fixed(int[] arr){
        int tmp_ = arr[0];
        arr[0] = arr[1];
        arr[1] = tmp_;
    }
}
