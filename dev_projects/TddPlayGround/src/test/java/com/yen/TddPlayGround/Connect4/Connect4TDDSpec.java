package com.yen.TddPlayGround.Connect4;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


// https://bitbucket.org/vfarcic/tdd-java-ch05-design/src/master/src/test/java/com/packtpublishing/tddjava/ch05connect4/Connect4TDDSpec.java

class Connect4TDDSpec {

//    private Connect4 tested;
//
//    @Before
//    public void beforeEachTest() {
//        tested = new Connect4();
//    }

    @Test
    public void whenTheGameIsStartedTheBoardIsEmpty() {

        Connect4 tested = new Connect4();
        assertEquals(tested.getNumberOfDiscs(), 0);
    }

    // book p.94
    @Test
    public void whenDiscOutsideBoardThenRuntimeException(){

        Connect4 tested = new Connect4();
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

        Connect4 tested = new Connect4();
        int column = 0;
        assertEquals(tested.putDiscInColumn(column), 0);
    }

    @Test
    public void whenSecondDiscInsertedInColumnThenPositionIsOne(){

        Connect4 tested = new Connect4();
        int column = 1;
        assertEquals(tested.putDiscInColumn(column), 1);
    }

    @Test
    public void whenDiscInsertedThenNumberOfDiscsIncreases(){

        Connect4 tested = new Connect4();
        int column = 1;
        tested.putDiscInColumn(column);
        assertEquals(tested.getNumberOfDiscs(), 1);
    }

    @Test
    public void whenNoMoreRoomInColumnThenRuntimeException(){

        Connect4 tested = new Connect4();

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

        Connect4 tested = new Connect4();
        assertEquals(tested.getCurrentPlayer(), "R");
    }

    @Test
    public void whenSecondPlayerPlaysThenDiscColorIsRed(){

        Connect4 tested = new Connect4();
        int column = 1;
        tested.putDiscInColumn(column);
        assertEquals(tested.getCurrentPlayer(), "G");
    }

}