package Basics;

// https://www.youtube.com/watch?v=6i8C7nwdJFw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=364

public class InnerClassDemo3 {

    // seldom seen when development
    public void method_x(){
        // inner class
        class AA{

            }
        }

   // more common in development
   // return a class instance that implements Comparable interface
   public Comparable getComparable() {

       // create a class that implements Comparable interface
       // method 1
       class Mycomparable implements Comparable {
           @Override
           public int compareTo(Object o) {
               return 0;
           }
       }
       return new Mycomparable();
   }

    // method 2
//    return new Comparable() {
//        @Override
//        public int compareTo(Object o) {
//            return 0;
//            }
//       };
}