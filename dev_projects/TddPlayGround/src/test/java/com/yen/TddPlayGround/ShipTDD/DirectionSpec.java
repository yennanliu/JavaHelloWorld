package com.yen.TddPlayGround.ShipTDD;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// https://bitbucket.org/vfarcic/tdd-java-ch04-ship/src/req06-obstacles/src/test/java/com/packtpublishing/tddjava/ch04ship/DirectionSpec.java

class DirectionSpec {

    @Test
    public void whenGetFromShortNameNThenReturnDirectionN(){

        Direction direction = Direction.getFromShortName('N');
        assertEquals(direction, Direction.NORTH);
    }

    @Test
    public void whenGetFromShortNameWThenReturnDirectionW(){

        Direction direction = Direction.getFromShortName('W');
        assertEquals(direction, Direction.WEST);
    }

    @Test
    public void whenGetFromShortNameBThenReturnNone(){

        Direction direction = Direction.getFromShortName('B');
        assertEquals(direction, Direction.NONE);
    }

}