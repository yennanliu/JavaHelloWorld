package utils;

public class StringUtils {

    // https://stackoverflow.com/questions/26875877/how-to-multiply-a-string-by-an-integer
    
    private static String multiplyString(String str, int multiplier){

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < multiplier; i++) {
            sb.append(str);
        }
        return sb.toString();
    }


    // test
    public static void main(String[] args) {

        System.out.println(multiplyString("a", 4));
        System.out.println(multiplyString("a", 0));
    }

}
