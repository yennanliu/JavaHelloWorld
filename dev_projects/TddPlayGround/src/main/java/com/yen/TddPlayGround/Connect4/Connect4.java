package com.yen.TddPlayGround.Connect4;

// https://bitbucket.org/vfarcic/tdd-java-ch05-design/src/master/src/main/java/com/packtpublishing/tddjava/ch05connect4/Connect4.java
// book p. 85

// NOTE : in this example, we will use TDD and non TDD
// book p. 92

import java.util.Arrays;
import java.util.stream.IntStream;

public class Connect4 {

    // attr
    private static final int ROWS = 6;

    private static final int COLUMNS = 7;

    private static final String EMPTY = " ";

    private String[][] board = new String[ROWS][COLUMNS];

    private static final String RED = "R";

    private static final String GREEN = "G";

    private String currentPlayer = RED;

//    private final int maxDiscsInColumn = 6;
//    private int discNum;

    // constructor
    Connect4(){
        for (String[] row : board){
            Arrays.fill(row, EMPTY);
        }
    }


    public String getCurrentPlayer(){

        return this.currentPlayer;
    }

    public void SwitchPlayer(){

        if (RED.equals(this.currentPlayer)){
            this.currentPlayer = GREEN;
        }else{
            this.currentPlayer = RED;
        }
    }

    public int getNumberOfDiscs() {

        //return this.discNum; //0;
        return IntStream.range(0, COLUMNS).map(this::getNumberOfDiscsInColumn).sum();
    }

    private int getNumberOfDiscsInColumn(int column) {

        //int res = IntStream.range(0, ROWS).filter(row -> !EMPTY).equals(board[row][column]))).count();
        return (int) IntStream.range(0, ROWS)
                .filter(row -> !EMPTY
                        .equals(board[row][column]))
                .count();
    }

    public int putDiscInColumn(int column) {

        this.checkColumn(column);
        //System.out.println("this.discNum = " + this.discNum);
        int row = getNumberOfDiscsInColumn(column);
        this.checkPositionToInsert(row, column);
        board[row][column] = "X";
        System.out.println(">>> putDiscInColumn");

        // switch player
        SwitchPlayer();
        
        return column; //row; // TODO : verify should return column or row
    }

    private void checkPositionToInsert(int row, int column) {

        if (row == ROWS){
            throw new RuntimeException("No more room in column " + column);
        }
    }

    private void checkColumn(int column) {

        if (column < 0 || column > COLUMNS){
            throw new RuntimeException("Invalid column " + column);
        }
    }

}
