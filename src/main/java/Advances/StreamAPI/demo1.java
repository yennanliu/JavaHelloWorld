package Advances.StreamAPI;

// https://www.youtube.com/watch?v=2jCET8QnQXw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=676

/**
 *  Stream API demo 1
 *
 *    1) Stream API : for data manipulation (deal with CPU)
 *    2) Stream API VS collection
 *      -> collection focus on data storage (deal with memory)
 *    3) stream will NOT storage elements
 *    4) stream will NOT change source instance; they return result to the other new stream
 *    5) stream op is "lazy" operation, it will NOT be executed until result is called
 *    6) stream op steps:
 *          -> step 1) stream initiation
 *          -> step 2) stream op (filter, mapping..)
 *          -> step 3) terminate op
 *
 *    7) once terminated, stream result CAN NOT BE retrieved again
 */
public class demo1 {
}
