package Basics;

// https://dotblogs.com.tw/law1009/2012/01/06/64665

public class GetterSetterDemo1 {
    public static void main(String [] args){
        // run
        GetterSetterDemo1 hello = new GetterSetterDemo1();
        // run getter -> set up instance attribution
        hello.setHello("yaaaaa helo helo");
        // run setter -> get instance attribution
        System.out.println(hello.getHello());
    }

    // private variable
    private String hello = "";

    // setter
    public void setHello(String val){
        if (val != ""){
            // prevent empty val
            this.hello = val;
        }
    }

    // getter
    public String getHello(){
        return this.hello;
    }

}
