package com.yen.TddPlayGround.TicTacToc;

// book Java测试驱动开发 p.46
// https://bitbucket.org/vfarcic/tdd-java-ch03-tic-tac-toe/src/05-jacoco/src/test/java/com/packtpublishing/tddjava/ch03tictactoe/TicTacToeSpec.java

/** unit test for TicTacToe class */

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertThrows;

public class TicTacToeSpec {

//    @Autowired
//    TicTacToe ticTacToe;

    @Rule
    public ExpectedException exception = ExpectedException.none();
    //private TicTacToe ticTacToe;

//    @Before
//    public final void before(){
//        ticTacToe = new TicTacToe();
//    }

    @Test
    public void whenXOutsideBoardThenRuntimeException(){

        TicTacToe ticTacToe = new TicTacToe();

        Exception exception = assertThrows(RuntimeException.class, () -> {
            ticTacToe.play(5,2);
        });
        System.out.println("exception = " + exception);

        Exception exception2 = assertThrows(RuntimeException.class, () -> {
            ticTacToe.play(2,5);
        });
        System.out.println("exception2 = " + exception2);


        ticTacToe.play(1,2);
        ticTacToe.play(2,1);
    }


}
