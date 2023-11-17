package com.yen.TddPlayGround.TicTacTocMongo.mongo;

// https://bitbucket.org/vfarcic/tdd-java-ch06-tic-tac-toe-mongo/src/solved/src/main/java/com/packtpublishing/tddjava/ch03tictactoe/mongo/TicTacToeBean.java

public class TicTacToeBean {

    private int turn;

    private int x;

    private int y;

    private char player;

    public TicTacToeBean(int turn, int x, int y, char player) {

        this.turn = turn;
        this.x = x;
        this.y = y;
    }

    public int getX() {

        return this.x;
    }

    public int getY() {

        return this.y;
    }

}
