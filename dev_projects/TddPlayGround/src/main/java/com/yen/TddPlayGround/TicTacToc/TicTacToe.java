package com.yen.TddPlayGround.TicTacToc;

// https://bitbucket.org/vfarcic/tdd-java-ch03-tic-tac-toe/src/master/src/main/java/com/packtpublishing/tddjava/ch03tictactoe/TicTacToe.java

public class TicTacToe {

    private Character[][] board = {{'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};
    private char lastPlayer = '\0';
    private static final int SIZE = 3;

    private int round = 0;

    public String play(int x, int y) {

        checkXAxis(x);
        checkYAxis(y);

        this.lastPlayer = nextPlayer();
        setBox(x,y, lastPlayer);
        //this.round += 1;

        // check winner
        for (int idx = 0; idx < 3; idx++){
            if (board[0][idx] == lastPlayer &&
                board[1][idx] == lastPlayer &&
                board[2][idx] == lastPlayer){
                return lastPlayer + " is the winner";
            }
        }

        return "No winner";
    }

    private void checkXAxis(int x){
        if (x < 1 || x > 3){
            throw new RuntimeException("X is out of bound");
        }
    }

    private void checkYAxis(int y){
        if (y < 1 || y > 3){
            throw new RuntimeException("Y is out of bound");
        }
    }

    private void setBox(int x, int y, char lastPlayer){

        if (board[x-1][y-1] != '\0'){
            throw new RuntimeException("place is occupied");
        }

        board[x-1][y-1] = lastPlayer;
    }

    public char nextPlayer() {

//        if (this.round % 2 == 0){
//            return 'X';
//        }
//        return 'O';

        if (lastPlayer == 'X'){
            return 'O';
        }
        return 'X';
    }

}
