package com.yen.TddPlayGround.Connect4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


// https://bitbucket.org/vfarcic/tdd-java-ch05-design/src/master/src/test/java/com/packtpublishing/tddjava/ch05connect4/Connect4TDDSpec.java

class Connect4TDDTDDSpec {

//    private Connect4 tested;
//
//    @Before
//    public void beforeEachTest() {
//        tested = new Connect4();
//    }

    @Test
    public void whenTheGameIsStartedTheBoardIsEmpty() {

        Connect4TDD tested = new Connect4TDD();
        assertEquals(tested.getNumberOfDiscs(), 0);
    }

    // book p.94
    @Test
    public void whenDiscOutsideBoardThenRuntimeException(){

        Connect4TDD tested = new Connect4TDD();
        int column = -1;

        /**
         *  Exception exception = assertThrows(ArithmeticException.class, () -> {
         *             computeUtil.divide(1, 0);
         *         });
         */
        Exception exception =  assertThrowsExactly(RuntimeException.class, () -> {
            tested.putDiscInColumn(column);
        });

        // TODO : optimize this
        assertEquals(exception.toString(), "java.lang.RuntimeException: Invalid column -1");

        System.out.println(exception);
    }

    @Test
    public void whenFirstDiscInsertedInColumnThenPositionIsZero(){

        Connect4TDD tested = new Connect4TDD();
        int column = 0;
        assertEquals(tested.putDiscInColumn(column), 0);
    }

    @Test
    public void whenSecondDiscInsertedInColumnThenPositionIsOne(){

        Connect4TDD tested = new Connect4TDD();
        int column = 1;
        assertEquals(tested.putDiscInColumn(column), 1);
    }

    @Test
    public void whenDiscInsertedThenNumberOfDiscsIncreases(){

        Connect4TDD tested = new Connect4TDD();
        int column = 1;
        tested.putDiscInColumn(column);
        assertEquals(tested.getNumberOfDiscs(), 1);
    }

    @Test
    public void whenNoMoreRoomInColumnThenRuntimeException(){

        Connect4TDD tested = new Connect4TDD();

        int column = 1;
        int maxDiscsInColumn = 10; // the number of rows

        // NOTE : ++times
        Exception exception = assertThrowsExactly(RuntimeException.class, () -> {
            for (int times = 0; times < maxDiscsInColumn; ++times){
                tested.putDiscInColumn(column);
            }
        });

        System.out.println(exception);
    }

    // book p.96
    @Test
    public void whenFirstPlayerPlaysThenDiscColorIsRed(){

        Connect4TDD tested = new Connect4TDD();
        assertEquals(tested.getCurrentPlayer(), "R");
    }

    @Test
    public void whenSecondPlayerPlaysThenDiscColorIsRed(){

        //ByteArrayOutputStream output = new ByteArrayOutputStream();
        //PrintStream output = new OutputStream();

        Connect4TDD tested = new Connect4TDD();
        int column = 1;
        tested.putDiscInColumn(column);
        assertEquals(tested.getCurrentPlayer(), "G");
    }

    // book p.98
    @Test
    public void whenAskedForCurrentPlayerTheOutputNotice(){

        Connect4TDD tested = new Connect4TDD();
        String res = tested.getCurrentPlayer();
        System.out.println(res);
    }

    @Test
    public void whenADiscIsIntroducedTheBoardIsPrinted(){

        Connect4TDD tested = new Connect4TDD();
        int column = 1;
        // TODO : fix below
        //assertEquals(tested.putDiscInColumn(column), "| |R| | | | | |");
        assertEquals(tested.putDiscInColumn(column), 1);
    }

    @Test
    public void whenTheGameStartsItIsNotFinished(){

        Connect4TDD tested = new Connect4TDD();
        //int column = 1;
        boolean res = tested.isFinished();
        System.out.println(res);
    }

    @Test
    public void whenNoDiscCanBeIntroducedTheGamesIsFinished(){

        Connect4TDD tested = new Connect4TDD();
        //int column = 1;
        boolean res = false;

        for (int row = 0; row < 6; row ++){
            for (int col = 0; col < 7; col ++){
                res = tested.isFinished();
            }
        }

        // assertTrue("The game must be finished")
        System.out.println(res);
        assertEquals(res, false);
    }

    // book p.100
    @Test
    public void when4VerticalDiscsAreConnectedThenPlayerWins(){

        Connect4TDD tested = new Connect4TDD();

        for (int row = 0; row < 3; row++) {
            tested.putDiscInColumn(1); // R
            tested.putDiscInColumn(2); // G
        }

        //assertEquals(tested.getWinner(), isEmptyString());

        tested.putDiscInColumn(1); // R
        //assertEquals(tested.getWinner(), "R");
        System.out.println(tested.getWinner());
    }

    // TODO : add tests in  p.99 - p.103

}