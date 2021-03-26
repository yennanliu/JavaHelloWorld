package Basics.thisDemo1;

public class BoyGirlTest {
    public static void main(String[] args){
        // run
        Boy boy = new Boy("kyo", 21);
        boy.shout();

        Girl girl = new Girl("Athena", 18);
        girl.marry(boy);

        Girl girl2 = new Girl("Merry", 19);
        System.out.println( girl.compare(girl2));

        System.out.println( girl2.compare(girl));
    }
}
