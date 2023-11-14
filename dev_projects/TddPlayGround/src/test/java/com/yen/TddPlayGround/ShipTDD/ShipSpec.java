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

//    private Ship ship;
//    private Planet planet;
//    private Location location;
//
//    @BeforeTestMethod
//    public void beforeTest(){
//        Point max = new Point(50, 50);
//        location = new Location(new Point(21, 13), Direction.NORTH);
//        Planet planet = new Planet(max);
//        ship = new Ship(location, planet);
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

        Point max = new Point(50, 50);
        Location location = new Location(new Point(21, 13), Direction.NORTH);
        Planet planet = new Planet(max);
        Ship ship = new Ship(location, planet);


//        Location location = new Location(
//                new Point(21, 13), Direction.NORTH);
        //Ship ship = new Ship(location);

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


    // book p.74
    @Test
    public void whenTurnLeftThenLeft() {

        Location location = new Location(
                new Point(21, 13), Direction.NORTH);
        Ship ship = new Ship(location);

        Location expected = location.copy();
        expected.turnLeft();
        ship.turnLeft();
        assertEquals(ship.getLocation(), expected);
    }

    @Test
    public void whenTurnRightThenRight() {

        Location location = new Location(
                new Point(21, 13), Direction.NORTH);
        Ship ship = new Ship(location);

        Location expected = location.copy();
        expected.turnRight();
        ship.turnRight();
        assertEquals(ship.getLocation(), expected);
    }

    @Test
    public void whenReceiveCommandsFThenForward(){


        Point max = new Point(50, 50);
        Location location = new Location(new Point(21, 13), Direction.NORTH);
        Planet planet = new Planet(max);
        Ship ship = new Ship(location, planet);

//        Location location = new Location(
//                new Point(21, 13), Direction.NORTH);
//        Ship ship = new Ship(location);

        Location expected = location.copy();
        expected.forward();
        ship.receiveCommands("f");
        assertEquals(ship.getLocation(), expected);
    }


    // book p.76
    @Test
    public void whenReceiveCommandsThenAllAreExecuted() {

        Point max = new Point(50, 50);
        Location location = new Location(new Point(21, 13), Direction.NORTH);
        Planet planet = new Planet(max);
        Ship ship = new Ship(location, planet);

//        Location location = new Location(
//                new Point(21, 13), Direction.NORTH);
//        Ship ship = new Ship(location);

        Location expected = location.copy();
        expected.turnRight();
        expected.forward();
        expected.turnLeft();
        expected.backward();
        ship.receiveCommands("rflb");
        assertEquals(ship.getLocation(), expected);
    }


    @Test
    public void whenInstantiatedThenPlanetIsStored(){

        Location location = new Location(
                new Point(21, 13), Direction.NORTH);

        Point max = new Point(50, 50);
        Planet planet = new Planet(max);

        Ship ship = new Ship(location, planet);
        assertEquals(ship.getPlanet(), planet);
    }

    @Test
    public void overpassEastBoundary() {

        Location location = new Location(new Point(21, 13), Direction.NORTH);

        Point max = new Point(50, 50);
        Planet planet = new Planet(max);
        Ship ship = new Ship(location, planet);

        location.setDirection(Direction.EAST);
        location.getPoint().setX(planet.getMax().getX());
        ship.receiveCommands("f");
        assertEquals(location.getX(), 1);
    }

}