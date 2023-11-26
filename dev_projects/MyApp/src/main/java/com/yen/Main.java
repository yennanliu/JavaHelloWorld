package com.yen;

/**
 *  LB
 *
 *   1. registry instance
 *   2. channel selected
 *   3. address unique (can't register same again)
 *
 *  - It should be possible to register an instance,
 *
 *  - identified by an address
 *
 *  - Each address should be unique,
 *
 *  -  it should not be possible to register the same address more than once
 *
 *  - Load Balancer should accept up to 10 addresses (in total)
 *
 *  - consider concurrency
 *
 *  - validate input address
 *
 *   no db, in memory
 *   no http
 *
 *   high level :
 *
 *    server A  -> LB   (save)
 *              <-- id
 *
 *     server A  -> LB
 *               <--
 *
 *
 *
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}