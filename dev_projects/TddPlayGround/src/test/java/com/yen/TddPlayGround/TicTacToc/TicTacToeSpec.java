package com.yen.TddPlayGround.TicTacToc;

// book Java测试驱动开发 p.46
// https://bitbucket.org/vfarcic/tdd-java-ch03-tic-tac-toe/src/05-jacoco/src/test/java/com/packtpublishing/tddjava/ch03tictactoe/TicTacToeSpec.java

/** unit test for TicTacToe class */

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class TicTacToeSpec {

//    @Autowired
//    TicTacToe ticTacToe;

    @Rule
    public ExpectedException exception = ExpectedException.none();
    private TicTacToe ticTacToe = new TicTacToe();

//    @Before
//    public final void before(){
//        ticTacToe = new TicTacToe();
//        TicTacToe ticTacToe = new TicTacToe();
//    }

    @Test
    public void whenXOutsideBoardThenRuntimeException(){

        //TicTacToe ticTacToe = new TicTacToe();

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

    // book p.50
    @Test
    public void givenFirstTurnWhenNextPlayerThenX(){

        //TicTacToe ticTacToe = new TicTacToe();
        assertEquals('X', ticTacToe.nextPlayer());
    }

    @Test
    public void givenLastTurnWasXWhenNextPlayerThenO() {

        ticTacToe.play(1, 1);
        assertEquals('O', ticTacToe.nextPlayer());
    }

    @Test
    public void whenPlayThenNoWinner(){

        String res = ticTacToe.play(1,1);
        assertEquals("No winner", res);
    }

    @Test
    public void whenPlayAndWholeHorizontalLineThenWinner(){

        ticTacToe.play(1, 1); // X
        ticTacToe.play(1, 2); // O
        ticTacToe.play(2, 1); // X
        ticTacToe.play(2, 2); // O
        String actual = ticTacToe.play(3, 1); // X
        assertEquals("X is the winner", actual);
    }

    @Test
    public void whenPlayAndWholeVerticalLineThenWinner() {
        ticTacToe.play(2, 1); // X
        ticTacToe.play(1, 1); // O
        ticTacToe.play(3, 1); // X
        ticTacToe.play(1, 2); // O
        ticTacToe.play(2, 2); // X
        String actual = ticTacToe.play(1, 3); // O
        assertEquals("O is the winner", actual);
    }

    // p.55
    @Test
    public void whenPlayAndTopBottomDiagonalLineThenWinner() {
        ticTacToe.play(1, 1); // X
        ticTacToe.play(1, 2); // O
        ticTacToe.play(2, 2); // X
        ticTacToe.play(1, 3); // O
        String actual = ticTacToe.play(3, 3); // O
        assertEquals("X is the winner", actual);
    }

    @Test
    public void whenPlayAndBottomTopDiagonalLineThenWinner() {
        ticTacToe.play(1, 3); // X
        ticTacToe.play(1, 1); // O
        ticTacToe.play(2, 2); // X
        ticTacToe.play(1, 2); // O
        String actual = ticTacToe.play(3, 1); // O
        assertEquals("X is the winner", actual);
    }


}
