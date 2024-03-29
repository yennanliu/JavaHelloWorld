package com.yen.TddPlayGround.Connect4;

// Non TDD code : https://bitbucket.org/vfarcic/tdd-java-ch05-design/src/master/src/main/java/com/packtpublishing/tddjava/ch05connect4/Connect4.java
// book p. 85

// NOTE : in this example, we will use TDD and non TDD

// TDD code : https://bitbucket.org/vfarcic/tdd-java-ch05-design/src/master/src/main/java/com/packtpublishing/tddjava/ch05connect4/Connect4TDD.java
// book p. 92

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Connect4TDD {

    // attr
    private static final int ROWS = 7;

    private static final int COLUMNS = 7;

    private static final String EMPTY = " ";

    private String[][] board = new String[ROWS][COLUMNS];

    private static final String RED = "R";

    private static final String GREEN = "G";

    private String currentPlayer = RED;

    private static final String DELIMITER = "|";

    private static final int DISCS_TO_WIN = 4;
    private String winner = "";

    // constructor
    public Connect4TDD(){
        for (String[] row : board){
            Arrays.fill(row, EMPTY);
        }
    }

//    public Connect4(PrintStream out){
//
//        outputChannel = out;
//        for (String[] row : board){
//            Arrays.fill(row, EMPTY);
//        }
//    }

    // https://bitbucket.org/vfarcic/tdd-java-ch05-design/src/15093a989135a7a76246941ce3cc9624e3198dad/src/main/java/com/packtpublishing/tddjava/ch05connect4/Connect4.java#lines-57
    public void printBoard() {
        for (int row = ROWS - 1; row >= 0; row -= 1) {
            StringJoiner stringJoiner = new StringJoiner(DELIMITER, DELIMITER, DELIMITER);
            for (int col = 0; col < COLUMNS; col += 1) {
                stringJoiner.add(board[col][row].toString());
            }
            System.out.println(stringJoiner.toString());
        }
    }

//    public void printBoard(){
//        for (int row = ROWS - 1; row >= 0; row--){
//            // TODO : check this syntax
//            StringJoiner stringJoiner = new StringJoiner(DELIMITER, DELIMITER, DELIMITER);
//            Stream.of(board[row]).forEachOrdered(stringJoiner::add);
//            outputChannel.println(stringJoiner.toString());
//        }
//    }

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

        // print board
        printBoard();

        // switch player
        SwitchPlayer();

        //return column; //row; // TODO : verify should return column or row
        return column;
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

    public Boolean isFinished() {

        //assertFalse("The game must not be finished",
        //return "The game must not be finished";
        return this.getNumberOfDiscs() == COLUMNS * ROWS;
    }

    public String getWinner() {
        return winner;
    }

    public void checkWinner(int row, int column) {

        // BOOK p.100
        if (winner.isEmpty()){
            String colour = board[row][column];
            // TODO : double check below
            Pattern winPattern =
                    Pattern.compile(".*" + colour + "{" +
                            DISCS_TO_WIN + "}.*");

            String vertical = IntStream.range(0, ROWS)
                    .mapToObj(r -> board[r][column])
                    .reduce(String::concat).get();

            if (winPattern.matcher(vertical).matches()){
                winner = colour;
            }
        }
    }

}
