package Basics.EqualsDemo1;

// https://www.youtube.com/watch?v=l6YQByB9Bks&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=294

/**
 * Difference between == and equals()
 *
 * <p>1) == 1-1) ==, an operator 1-2) can be used on basic data type and inference data type 1-3)
 * type doesn't matter, -> == is Comparing their "actual value" in memory
 *
 * <p>1-4) If compare "basic data type" -> type don't need to be the same, ONLY compare their
 * "actual value" in memory
 *
 * <p>1-5) If compare "REFERENCE data type" -> will compare if their address in memory are the SAME
 * -> e.g. if they are belong to the same instance -> (plz check example 4 below)
 */
public class demo1 {
  public static void main(String[] args) {

    System.out.println("========== BASIC DATA TYPE ========== ");
    // example 1
    int i = 10;
    int j = 10;
    double d = 10.0;
    System.out.println(i == j); // true
    // automatic cast (double -> int)
    System.out.println(d == j); // true

    // example 2
    boolean b = true;
    // System.out.println(b == j); // not valid

    System.out.println("==============");

    // example 3
    // https://www.w3schools.com/java/java_data_types.asp
    // char	: 2 bytes	Stores a single character/letter or ASCII values
    char c = 10; // char c = 'k'
    System.out.println(c == j); // true

    System.out.println("==============");

    char c1 = 'A';
    char c2 = 65;
    System.out.println(c1 == c2); // true

    System.out.println("========== REFERENCE DATA TYPE ========== ");

    // example 4
    Customer cust1 = new Customer("tom", 21);
    Customer cust2 = new Customer("tom", 21);

    System.out.println("==============");

    // NOTE : cust1 and cust2 are in the different address (in memory)
    System.out.println(cust1 == cust2); // FALSE

    // example 5
    String str1 = new String("java");
    String str2 = new String("java");
    System.out.println(
        str1 == str2); // FALSE, same as above, str1 and str2 are in different address
  }
}
