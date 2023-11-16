package com.yen.TddPlayGround.TicTacTocMongo.mongo;

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

    @BeforeEach
    public void before() throws UnknownHostException{
        //collection = new TicTacToeCollection();
        // book p.112
        collection = spy(new TicTacToeCollection());
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

        TicTacToeBean bean = new TicTacToeBean(3,2,1, 'Y');

        // mock MongoCollection
        MongoCollection mongoCollection = mock(MongoCollection.class);
        // setup mock instance behaviour
        // -> return a mock instance (mongoCollection) when TicTacToeCollection.getMongoCollection() method is called
        doReturn(mongoCollection).when(collection).getMongoCollection();

        collection.saveMove(bean);

        verify(mongoCollection, times(1)).save(bean);
    }

}