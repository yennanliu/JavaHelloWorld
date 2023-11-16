package com.yen.TddPlayGround.TicTacTocMongo.mongo;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeCollectionSpec {

    //book p.109
    @Test
    public void whenInstantiatedThenMongoHasDbNameTicTacToe(){

        TicTacToeCollection collection = new TicTacToeCollection();
        assertEquals(collection.getMongoCollection().getDBCollection().getDB().getName(), "tic-tac-toe");
    }

}