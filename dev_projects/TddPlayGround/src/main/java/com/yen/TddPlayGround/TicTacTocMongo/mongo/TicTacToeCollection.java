package com.yen.TddPlayGround.TicTacTocMongo.mongo;

// https://bitbucket.org/vfarcic/tdd-java-ch06-tic-tac-toe-mongo/src/solved/src/main/java/com/packtpublishing/tddjava/ch03tictactoe/mongo/TicTacToeCollection.java

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import java.net.UnknownHostException;

public class TicTacToeCollection{

    private
    MongoCollection mongoCollection;

    // constructor
    public TicTacToeCollection() throws UnknownHostException {

        DB db = new MongoClient().getDB("tic-tac-toe");
        mongoCollection = new Jongo(db).getCollection("game");
    }

    // method
    // when TicTacToeCollection created via constructor, then mongoCollection instance is init
    // -> we can get such mongoCollection instance via getMongoCollection()
    protected MongoCollection getMongoCollection() {

        return mongoCollection;
    }

    public void saveMove(TicTacToeBean bean) {

        getMongoCollection().save(bean); // note here : we save bean
    }

}
