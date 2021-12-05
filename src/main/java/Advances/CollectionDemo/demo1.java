package Advances.CollectionDemo;

// https://www.youtube.com/watch?v=uplvcoAy_EI&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=512
// https://www.youtube.com/watch?v=J6OYuzYInYk&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=514

/**
 *   Collection demo 1
 *
 *   1) collection, array are structure/container for data storage/manipulation
 *      (internal storage,  (not persistent storage, e.g. .txt, .csv, DB..) )
 *
 *   2) array
 *      - 2-1) length is fixed (not dynamic) once initialized
 *          - length is NOT changeable once initialized
 *      - 2-2) need to define element type, element is fixed (not dynamic); polymorphism is possible
 *          - e.g. : String[] arr;
 *          - e.g. : int[] arr;
 *          - ONLY has one element type (but polymorphism is possible)
 *     - 2-3) array only offers limited methods, hard to do op such as : add, delete, modify, find
 *     - 2-4) low efficiency for some op
 *          - e.g. add : need to update, move idx for many elements
 *     - 2-5) ordering, repeatable
 *
 *   3) Collection framework:
 *      - Collection interface : single array collection, for storage every single element
 *          |--- List interface : storage ordering, repeatable element --> "dynamic" array
 *            |--- ArrayList : LinkedList, Vector
 *          |--- Set interface :  storage non-ordering, non-repeatable element
 *            |--- HashSet, LinkedHastSet, TreeSet
 *          |--- Map interface : double array collection, storage key-value pair
 *            |--- HashMap, LinkedHashMap, TreeMap, HashTable, Properties
 *
 *  4) 
 *
 */


public class demo1 {
}
