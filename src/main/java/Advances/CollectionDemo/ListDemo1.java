package Advances.CollectionDemo;

// https://www.youtube.com/watch?v=Y6U0PnnjNRs&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=527
// https://www.youtube.com/watch?v=iQnIoSjxdeo&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=528

/**
 *  List Demo1
 *    |-- List interface : storage ordering, duplicated record -> "dynamic" array
 *      |--- ArrayList : LinkedList, Vector
 *
 *  1) List is Collection's sub interface
 *  2) we usually use this (List) in java
 *  3) List has ordering elements, duplicated elements (every element has its order index)
 *  4) we can get element from List via index
 *  5) common implemented class :
 *      - ArrayList
 *      - LinkedList
 *      - Vector
 *  6) ArrayList VS LinkedList VS Vector ?
 *    same :   all of the 3 classes implements list interface. Can storage ordering, duplicated records
 *    difference  :
 *                  - ArrayList  : main implemented class from List interface. thread non safety, high efficiency. Under the hood : use Object[] for storage
 *                  - LinkedList : use case : frequent add, delete op. LinkedList has better performance than ArrayList. Under the hood : use dequeue (double direction queue) for storage
 *                  - Vector : `aged` (old) implemented class from List interface (since JDK 1). thread safety, low efficiency. Under the hood : use Object[] for storage
 *
 *  7) ArrayList in JDK 8
 *      - ArrayList List = new ArrayList() // under the hood Object[] elementData init as {}, not create array yet
 *
 *  8) Summary :
 *      - JDK 7 : ArrayList instantiate similar singlet's lazy Eager initialization (餓漢式)
 *      - JDK 8 : ArrayList instantiate similar singlet's lazy initialization (懶漢式)
 *                - delay class creation, save resource
 *
 */

public class ListDemo1 {
    public static void main(String[] args) {

    }
}
