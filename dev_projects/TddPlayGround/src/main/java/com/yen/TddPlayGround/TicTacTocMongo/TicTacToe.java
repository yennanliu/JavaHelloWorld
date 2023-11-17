package com.yen.TddPlayGround.TicTacTocMongo;

// https://bitbucket.org/vfarcic/tdd-java-ch06-tic-tac-toe-mongo/src/solved/src/main/java/com/packtpublishing/tddjava/ch03tictactoe/TicTacToe.java

import com.yen.TddPlayGround.TicTacTocMongo.mongo.TicTacToeCollection;

import java.net.UnknownHostException;

public class TicTacToe {

    private TicTacToeCollection ticTacToeCollection;
    protected TicTacToeCollection getTicTacToeCollection() {
        return ticTacToeCollection;
    }

    public TicTacToe() throws UnknownHostException {
        this(new TicTacToeCollection());
    }
    public TicTacToe(TicTacToeCollection collection) {
        ticTacToeCollection = collection;
        if (!ticTacToeCollection.drop()) {
            throw new RuntimeException("Dropping DB collection failed");
        }
    }

}
