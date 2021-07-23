package Basics.EmployeeCRM.team.utils;

// https://www.youtube.com/watch?v=wcC_8L6Yf9o&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=388

import java.util.*;

public class TSUtility {

    private static Scanner scanner = new Scanner(System.in);
    /**
     *
     * @Description 该方法读取键盘，如果用户键入’1’-’4’中的任意字符，则方法返回。返回值为用户键入字符。
     * @author shkstart
     * @date 2019年2月12日上午12:03:30
     * @return
     */
    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' &&
                    c != '3' && c != '4') {
                System.out.print("invalid input, plz try again：");
            } else break;
        }
        return c;
    }
    /**
     *
     * @Description 该方法提示并等待，直到用户按回车键后返回。
     * @author shkstart
     * @date 2019年2月12日上午12:03:50
     */
    public static void readReturn() {
        System.out.print("press enter to continue...");
        readKeyBoard(100, true);
    }
    /**
     *
     * @Description 该方法从键盘读取一个长度不超过2位的整数，并将其作为方法的返回值。
     * @author shkstart
     * @date 2019年2月12日上午12:04:04
     * @return
     */
    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("invalid input, plz try again：");
            }
        }
        return n;
    }
    /**
     *
     * @Description 从键盘读取‘Y’或’N’，并将其作为方法的返回值。
     * @author shkstart
     * @date 2019年2月12日上午12:04:45
     * @return
     */
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("invalid input, plz try again：");
            }
        }
        return c;
    }

    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) return line;
                else continue;
            }

            if (line.length() < 1 || line.length() > limit) {
                System.out.print("input length（<=" + limit + "）wrong，plz input again：");
                continue;
            }
            break;
        }

        return line;
    }
}

