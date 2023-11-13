package com.yen.TddPlayGround.TicTacToc;

// book Java测试驱动开发 p.46
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
        setBox(x,y,lastPlayer);

        // check winner
        if (isWin()){
            return lastPlayer + " is the winner";
        }

        // check if draw game
        if (isDraw()){
            return "The result is draw";
        }

        return "No winner";
    }

    private boolean isWin(){

        int winScore = lastPlayer * SIZE;

        // check Y axis
        for (int i = 0; i < SIZE; i++){
            if (board[0][i] + board[1][i] + board[2][i] == winScore){
                return true;
            }
        }

        // check X axis // (0,1), (0,2), (0,3)
        for (int j = 0; j < SIZE; j++){
            if (board[j][0] + board[j][1] + board[j][2] == winScore){
                return true;
            }
        }

        // check diagonal
        if (board[0][0] + board[1][1] + board[2][2] == winScore){
            return true;
        }

        if (board[0][2] + board[1][1] + board[2][0] == winScore){
            return true;
        }

        return false;
    }

    private boolean isDraw(){

        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                // if there is any "Non occupied" place
                if (board[i][j] == '\0'){
                    return false;
                }
            }
        }
        return true;
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

        if (lastPlayer == 'X'){
            return 'O';
        }
        return 'X';
    }

}
