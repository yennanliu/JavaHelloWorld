package com.yen.TddPlayGround.TicTacTocMongo.mongo;

// https://bitbucket.org/vfarcic/tdd-java-ch06-tic-tac-toe-mongo/src/solved/src/main/java/com/packtpublishing/tddjava/ch03tictactoe/mongo/TicTacToeCollection.java

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

public class TicTacToeCollection {

    private
    MongoCollection mongoCollection;

    // constructor
    public TicTacToeCollection(){

        DB db = new MongoClient().getDB("tic-tac-toe");
        mongoCollection = new Jongo(db).getCollection("bla");
    }

    // method
    protected MongoCollection getMongoCollection() {

        return mongoCollection;
    }

}
