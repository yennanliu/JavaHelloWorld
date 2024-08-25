package com.yen.dev;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class BufferTest {

    // https://youtu.be/N48V1B7JzTk?si=Z7fPNdPPaNMtfESe&t=1345
    @Test
    public void test1() throws InterruptedException {

        /**
         *  bufferUntilChanged : good for 1 to N operation
         *
         *  example output:
         *
         * list = [0]
         * list = [1, 2, 3]
         * list = [4]
         * list = [5, 6, 7]
         * list = [8]
         * list = [9]
         */
        Flux.range(0,10)
                .bufferUntilChanged(x -> x % 4 == 0)
                .subscribe(list -> System.out.println("list = " + list));

        Thread.sleep(20000);
    }

}
