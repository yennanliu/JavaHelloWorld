package Basics;

// https://www.youtube.com/watch?v=LYDPr8sDWwg&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=208

public class DynamicNumVar1 {
    public static void main(String[] args) {
        // run
        DynamicNumVarClass test = new DynamicNumVarClass();
        test.show(777);
        test.show("hi hihihi hi");
        test.show("i", "love", "you");
        test.show();
        // do it via Anonymous Object
        test.show(new String[]{"AA", "BB", "CC"});

        //String[] str_ = new String[]{"AA", "BB", "CC"};
        //test.show(str_);
    }
}

class DynamicNumVarClass {
    public void show(int i){
    }

    public void show(String s){
    }

    // Dynamic Number of Var
    // notice : the Dynamic vars need to be put in the "final" ordering
    public void show(String ... strs){
        for (int i = 0 ; i < strs.length ; i ++ ){
            System.out.println(strs[i]);
        }

    }
}

