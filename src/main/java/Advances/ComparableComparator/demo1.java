package Advances.ComparableComparator;

// https://www.youtube.com/watch?v=n3xOIVricqQ&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=490
// https://www.youtube.com/watch?v=iCKc2-vslbg&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=491
// https://www.youtube.com/watch?v=PArFjm04xkg&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=492

/**
 *  Comparable Comparator demo1
 *
 *  1) default in Java, we can only do `==` or `!=`, but not `>` or `<`.
 *     . However, in some cases, we need to ordering (compare) the instances.
 *     -> `Comparable`, and `Comparator` are the interface for that
 *
 *  2) Comparable interface demo (natural ordering)
 *
 *    2-1) String implements Comparable interface, override compareTo() method
 *      -> so it can compare instances (> or <)
 *
 *    2-2) String, wrapper class' override compareTo()
 *      -> will return smallest -> biggest
 *
 *    2-3) String, wrapper class' override compareTo() rules:
 *      -> if current instance (this.xxx) > obj : return positive int
 *      -> if current instance (this.xxx) < obj : return negative int
 *      -> if current instance (this.xxx) < obj : return 0
 *
 *    2-4) For user-defined class, if we need to ordering it,
 *        -> we need to implement Comparable interface, override compareTo(obj) method
 *        -> we need to implement  `how to sorting` logic in compareTo(obj)
 *
 *  3) Comparator interface (custom ordering)
 *
 *     3-1) use case :
 *          3-3-1) when the class hasn't implemented Comparable interface, and it's hard to modify the code
 *          3-3-2) when current implemented Comparable not fit our requirement
 *           -> we can consider use Comparator
 *
 *    3-2) override compare(Object o1, Object o2)
 *         -> compare o1, o2
 *             -> if o1 > o2 : return positive int
 *             -> if o1 < o2 : return negative int
 *             -> if o1 == o2 : return 0
 *
 *  4) Comparable VS Comparator
 *
 *      -> Comparable implementation can be used in any place (once defined)
 *      -> Comparator can only being used in that temperate place
 */

import java.util.Arrays;
import java.util.Comparator;
import org.junit.jupiter.api.Test;

public class demo1 {
    @Test
    public void demo1(){

        /** Ordering string array */
        String[] arr1 = new String[]{"dd","aa","cc","bb"};
        Arrays.sort(arr1);

        System.out.println(Arrays.toString(arr1)); // [aa, bb, cc, dd]
    }

    @Test
    public void demo2(){

        /** Ordering customized class (Goods class) (Advances.ComparableComparator.Goods.java) */
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("iphone", 1000);
        arr[1] = new Goods("pixel", 800);
        arr[2] = new Goods("x11", 200);
        arr[3] = new Goods("samsung", 100);

        System.out.println(Arrays.toString(arr)); // [Good{name='iphone', price=1000.0}, Good{name='pixel', price=800.0}, Good{name='x11', price=200.0}, Good{name='samsung', price=100.0}]

        // sort
        // if not implement Comparable or Comparator, then will face `java.lang.ClassCastException: class Advances.ComparableComparator.Goods cannot be cast to class java.lang.Comparable (Advances.ComparableComparator.Goods is in unnamed module of loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')` error
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr)); // [Good{name='samsung', price=100.0}, Good{name='x11', price=200.0}, Good{name='pixel', price=800.0}, Good{name='iphone', price=1000.0}]
    }

    @Test
    public void demo3(){

        /** Comparator example : string Array */
        String[] arr1 = new String[]{"dd","aa","cc","bb"};

        System.out.println(Arrays.toString(arr1));

        // ordering string from big to small
        Arrays.sort(arr1, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -1 * s1.compareTo(s2);
                }
                // *** NOTE this we throw, but not return
                throw new RuntimeException("input type mismatch!");
            }
        });
        System.out.println(Arrays.toString(arr1)); // [dd, cc, bb, aa]
    }

    @Test
    public void demo4(){

        /** Comparator example : user-defined class */

        Goods[] arr = new Goods[4];
        arr[0] = new Goods("iphone", 1000);
        arr[1] = new Goods("pixel", 800);
        arr[2] = new Goods("x11", 200);
        arr[3] = new Goods("samsung", 100);

        System.out.println(Arrays.toString(arr)); // [Good{name='iphone', price=1000.0}, Good{name='pixel', price=800.0}, Good{name='x11', price=200.0}, Good{name='samsung', price=100.0}]

        Arrays.sort(arr, new Comparator() {
            // ordering by name (low->high), then price (high->low)
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods && o2 instanceof Goods){
                    Goods g1 = (Goods) o1;
                    Goods g2 = (Goods) o2;
                    if (g1.getName().equals(g2.getName())){
                        return -1 * Double.compare(g1.getPrice(), g2.getPrice());
                    }else{
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                // *** NOTE this we throw, but not return
                throw new RuntimeException("input type mismatch !");
            }
        });

        System.out.println(Arrays.toString((arr)));
    }
}
