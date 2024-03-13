package utils;

public class StringUtil {

    // https://stackoverflow.com/questions/2255500/can-i-multiply-strings-in-java-to-repeat-sequence
    private String multiplyStr(String s, int multiply){
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < multiply; i++){
            r.append(s);
        }
        return r.toString();
    }

//    public static void main(String[] args) {
//        String res = multiplyStr("0", 3);
//        System.out.println(res);
//    }

}
