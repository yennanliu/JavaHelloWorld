package com.yen.TddPlayGround.TicTacTocMongo;

import com.yen.TddPlayGround.TicTacTocMongo.mongo.TicTacToeBean;
import com.yen.TddPlayGround.TicTacTocMongo.mongo.TicTacToeCollection;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;


/**
 *  How to fix Junit 5 "null pointer" error when use @Before
 *
 *    - https://stackoverflow.com/questions/61692036/setup-function-is-throwing-nullpointerexception-when-using-beforeeach-in-juni
 *
 *    -> so, do below
 *      - 1) add annotaiton : @ExtendWith(MockitoExtension.class)
 *      - 2) use @BeforeEach
 */
@ExtendWith(MockitoExtension.class)
class TicTacToeSpec {

    // TODO : check what's @Rule
    @Rule
    public ExpectedException exception = ExpectedException.none();
    private TicTacToe ticTacToe;
    private TicTacToeCollection collection;

    // book p.120
    @BeforeEach
    public final void before() throws UnknownHostException {

        collection = mock(TicTacToeCollection.class);

//        doReturn(true).when(collection).drop();
//        doReturn(true).when(collection).saveMove(any(TicTacToeBean.class));

        ticTacToe = new TicTacToe(collection);
    }

    @Test
    public void whenInstantiatedThenSetCollection() {

        assertNotNull(ticTacToe.getTicTacToeCollection());
    }

    @Test
    public void test_1(){
//        System.out.println("123");
//        assertEquals(true, true);
    }

//    @Test
//    public void whenPlayThenSaveMoveIsInvoked() {
//        TicTacToeBean move = new TicTacToeBean(1, 1, 3, 'X');
//        ticTacToe.play(move.getX(), move.getY());
//        verify(collection, times(1)).saveMove(move);
//    }

}