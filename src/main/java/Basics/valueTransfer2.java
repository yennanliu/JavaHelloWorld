package Basics;

// https://www.youtube.com/watch?v=26FZPGNSZlg&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=211

// plz compare with valueTransfer1

public class valueTransfer2 {
    public static void main(String[] args){

        // run
        Data data = new Data();
        data.m = 1;
        data.n = 3;
        System.out.println("m = " + data.m + ", n = " + data.n);

        System.out.println("==================");

        // 1) let's try to swap m, n below (do directly)
        int tmp = data.m;
        data.m = data.n;
        data.n = tmp;
        System.out.println("m = " + data.m + ", n = " + data.n);

        System.out.println("==================");

        // 2) do as 1), but via a method
        // since we're in the "static" main in valueTransfer1,
        // so we need to instantiate it (new), so can use the method (swap_) under it
        data.m = 1; // init m, n again
        data.n = 3;

        valueTransfer2 test = new valueTransfer2();
        test.swap_2(data);
        System.out.println("m = " + data.m + ", n = " + data.n);
    }

    // method
    // in here, we use "Data" type as input,
    // and since "Data" is "reference" value (not basic value)
    // -> so it points to somewhere in heap space (while m=1, n=3 are in the "heap" space actually)
    public void swap_2(Data data) {
        // do the swap in place
        int tmp_ = data.m;
        data.m = data.n;
        data.n = tmp_;
    }
}

class Data {
    int m;
    int n;
}