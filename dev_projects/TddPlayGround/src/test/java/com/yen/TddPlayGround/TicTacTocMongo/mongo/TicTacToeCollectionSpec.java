package com.yen.TddPlayGround.TicTacTocMongo.mongo;

import com.mongodb.MongoException;
import org.jongo.MongoCollection;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.UnknownHostException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
class TicTacToeCollectionSpec {

    TicTacToeCollection collection;

    MongoCollection mongoCollection;

    TicTacToeBean bean;

    @BeforeEach
    public void before() throws UnknownHostException{
        //collection = new TicTacToeCollection();
        // book p.112
        collection = spy(new TicTacToeCollection());
        // book p.115
        bean = new TicTacToeBean(3,2,1, 'Y');
        mongoCollection = mock(MongoCollection.class);
    }


    //book p.109
    @Test
    public void whenInstantiatedThenMongoHasDbNameTicTacToe() throws UnknownHostException {

        //TicTacToeCollection collection = new TicTacToeCollection();
        assertEquals(collection.getMongoCollection().getDBCollection().getDB().getName(), "tic-tac-toe");
    }

    @Test
    public void whenInstantiatedThenMongoCollectionHasNameGame() throws UnknownHostException {

        //TicTacToeCollection collection = new TicTacToeCollection();
        assertEquals(collection.getMongoCollection().getDBCollection().getName(), "game");
    }

    // book p.112
    @Test
    public void whenSaveMoveThenInvokeMongoCollectionSave(){

        //TicTacToeBean bean = new TicTacToeBean(3,2,1, 'Y');

        // mock MongoCollection
        //MongoCollection mongoCollection = mock(MongoCollection.class);
        // setup mock instance behaviour
        // -> return a mock instance (mongoCollection) when TicTacToeCollection.getMongoCollection() method is called
        doReturn(mongoCollection).when(collection).getMongoCollection();

        collection.saveMove(bean);

        // verify method called result
        verify(mongoCollection, times(1)).save(bean);
    }

    @Test
    public void whenSaveMoveThenReturnTrue(){

        //TicTacToeBean bean = new TicTacToeBean(3,2,1, 'Y');
        // mock
        //MongoCollection mongoCollection = mock(MongoCollection.class);
        // setup mock instance behaviour
        // -> return a mock instance (mongoCollection) when TicTacToeCollection.getMongoCollection() method is called

        doReturn(mongoCollection).when(collection).getMongoCollection();
        assertEquals(collection.saveMove(bean), true);
    }

    // book p.116
    @Test
    public void givenExceptionWhenSaveMoveThenReturnFalse(){

        // check if MongoException is thrown
        doThrow(new MongoException("bla"))
                .when(mongoCollection)
                .save(any(TicTacToeBean.class));

        // check if mongoCollection is return
        doReturn(mongoCollection)
                .when(collection)
                .getMongoCollection();

        assertFalse(collection.saveMove(bean));
    }

    // book p.117
    @Test
    public void whenDropThenInvokeMongoCollectionDrop(){

        // check
        doReturn(mongoCollection)
                .when(collection)
                .getMongoCollection();
        collection.drop();
        verify(mongoCollection).drop();
    }

    @Test
    public void whenDropThenReturnTrue(){

        doReturn(mongoCollection)
                .when(collection)
                .getMongoCollection();
        assertTrue(collection.drop());
    }

    @Test
    public void givenExceptionWhenDropThenReturnFalse(){

        doThrow(new MongoException("bla"))
                .when(mongoCollection)
                .drop();

        doReturn(mongoCollection)
                .when(collection)
                .getMongoCollection();

        assertFalse(collection.drop());
    }

}