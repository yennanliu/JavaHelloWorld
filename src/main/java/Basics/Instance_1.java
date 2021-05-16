package Basics;

// https://www.youtube.com/watch?v=iB2jEAaeTzc&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=277

/**
 *  Steps of subclass instantiation
 *
 *  1) from result point of view (inheritance)
 *        -> when subclass inherit from superclass => it will receive attr, method.. in superclass
 *        -> in heap space, it will load all attr defined in superclass
 *
 *  2) from progress point of view
 *        -> when we create subclass instance via subclass constructor => we must DIRECT/IN-DIRECT call constructor in superclass
 *        -> e.g. : superclass constructor -> superclass1 constructor -> superclass2 constructor -> ..... -> java.lang.Object
 *
 */

public class Instance_1 {
}
