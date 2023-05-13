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

    // https://stackoverflow.com/questions/49126461/java-reverse-string-method
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }


    // test
    public static void main(String[] args) {

        System.out.println(multiplyString("a", 4));
        System.out.println(multiplyString("a", 0));

        String x = "abc";
        System.out.println(x);
        System.out.println(reverseString(x));
    }

}
