package com.yen.TddPlayGround.ShipTDD;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import static org.junit.jupiter.api.Assertions.*;

/** test class for Ship */
// book p.70

class ShipSpec {

    // TODO : fix can run with below
//    private Ship ship;
//    private Location location;
//
//    @BeforeTestMethod
//    public void beforeTest(){
//        Location location = new Location(
//                new Point(21, 13), Direction.NORTH);
//        ship = new Ship(location);
//    }

    @Test
    public void whenInstantiatedThenLocationIsSet() {
        Location location = new Location(
                new Point(21, 13), Direction.NORTH);
        Ship ship = new Ship(location);
        assertEquals(ship.getLocation(), location);
    }

    // book p.73
    @Test
    public void whenMoveForwardThenForward(){

        Location location = new Location(
                new Point(21, 13), Direction.NORTH);
        Ship ship = new Ship(location);

        Location expected = location.copy();
        expected.forward();
        ship.moveForward();
        assertEquals(ship.getLocation(), expected);
    }

    // book p.73
    @Test
    public void whenMoveBackwardThenBackward() {

        Location location = new Location(
                new Point(21, 13), Direction.NORTH);
        Ship ship = new Ship(location);

        Location expected = location.copy();
        expected.backward();
        ship.moveBackward();
        assertEquals(ship.getLocation(), expected);
    }


}