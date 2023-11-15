package com.yen.TddPlayGround.Connect4;

// https://bitbucket.org/vfarcic/tdd-java-ch05-design/src/master/src/main/java/com/packtpublishing/tddjava/ch05connect4/Connect4.java
// book p. 85

// NOTE : in this example, we will use TDD and non TDD
// book p. 92

public class Connect4 {

    private int discNum;

    private final int maxDiscsInColumn = 6;

    public int getNumberOfDiscs() {

        return this.discNum; //0;
    }

    public int putDiscInColumn(int column) {

        System.out.println("this.discNum = " + this.discNum);

        if (column < 0){
            throw new RuntimeException("Invalid column " + column);
        }

        if (this.discNum >= maxDiscsInColumn-1){
            throw new RuntimeException("No more room in column " + column);
        }

        this.discNum += 1;
        return column;
    }

}
