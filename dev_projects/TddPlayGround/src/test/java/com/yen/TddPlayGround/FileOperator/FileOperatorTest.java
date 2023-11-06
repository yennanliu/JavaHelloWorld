package com.yen.TddPlayGround.FileOperator;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileOperatorTest {

    FileOperator fileOperator = new FileOperator();

//    @Test
//    void testListFiles(){
//       List<String> res = fileOperator.listFiles("/");
//       System.out.println("res = " + res);
//    }

    @Test
    void testReadFile() throws FileNotFoundException {

        String expected = "null# TDD dev Projects## Quick start## Ref";
        assertEquals(fileOperator.readFile("README.md"), expected);

        assertThrows(java.io.FileNotFoundException.class, () -> {
            fileOperator.readFile("xxx.txt");
        });
    }

}