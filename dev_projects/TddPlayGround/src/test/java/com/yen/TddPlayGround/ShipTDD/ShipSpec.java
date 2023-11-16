package com.yen.TddPlayGround.ShipTDD;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/** test class for Ship */
// book p.70
// https://bitbucket.org/vfarcic/tdd-java-ch04-ship/src/req06-obstacles/src/test/java/com/packtpublishing/tddjava/ch04ship/ShipSpec.java

@ExtendWith(MockitoExtension.class)
class ShipSpec {

    // TODO : fix can run with below
    private Ship ship;
    private Location location;
    private Planet planet;

    @BeforeEach
    public void beforeTest(){
        Point max = new Point(50, 50);
        location = new Location(new Point(21, 13), Direction.NORTH);
        Planet planet = new Planet(max);
        ship = new Ship(location, planet);
    }

    @Test
    public void whenInstantiatedThenLocationIsSet() {
//        Location location = new Location(
//                new Point(21, 13), Direction.NORTH);
//        Ship ship = new Ship(location);
        assertEquals(ship.getLocation(), location);
    }

    // book p.73
    @Test
    public void whenMoveForwardThenForward(){

        // https://bitbucket.org/vfarcic/tdd-java-ch04-ship/src/5b832a142fab70505af2d9e3c7896cc5079bce32/src/test/java/com/packtpublishing/tddjava/ch04ship/ShipSpec.java#lines-19
        Point max = new Point(50, 50);
        Location location = new Location(new Point(21, 13), Direction.NORTH);
        List<Point> obstacles = new ArrayList<>();
        obstacles.add(new Point(44, 44));
        obstacles.add(new Point(45, 46));
        Planet planet = new Planet(max, obstacles);
        Ship ship = new Ship(location, planet);

//        Point max = new Point(50, 50);
//        Location location = new Location(new Point(21, 13), Direction.NORTH);
//        Planet planet = new Planet(max);
//        Ship ship = new Ship(location, planet);

        Location expected = location.copy();
        expected.forward();
        ship.moveForward();
        assertEquals(ship.getLocation(), expected);
    }

    // book p.73
    @Test
    public void whenMoveBackwardThenBackward() {

        // https://bitbucket.org/vfarcic/tdd-java-ch04-ship/src/5b832a142fab70505af2d9e3c7896cc5079bce32/src/test/java/com/packtpublishing/tddjava/ch04ship/ShipSpec.java#lines-19
        Point max = new Point(50, 50);
        Location location = new Location(new Point(21, 13), Direction.NORTH);
        List<Point> obstacles = new ArrayList<>();
        obstacles.add(new Point(44, 44));
        obstacles.add(new Point(45, 46));
        Planet planet = new Planet(max, obstacles);
        Ship ship = new Ship(location, planet);

//        Point max = new Point(50, 50);
//        Location location = new Location(new Point(21, 13), Direction.NORTH);
//        Planet planet = new Planet(max);
//        Ship ship = new Ship(location, planet);

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


//        Point max = new Point(50, 50);
//        Location location = new Location(new Point(21, 13), Direction.NORTH);
//        Planet planet = new Planet(max);
//        Ship ship = new Ship(location, planet);

        // https://bitbucket.org/vfarcic/tdd-java-ch04-ship/src/5b832a142fab70505af2d9e3c7896cc5079bce32/src/test/java/com/packtpublishing/tddjava/ch04ship/ShipSpec.java#lines-19
        Point max = new Point(50, 50);
        Location location = new Location(new Point(21, 13), Direction.NORTH);
        List<Point> obstacles = new ArrayList<>();
        obstacles.add(new Point(44, 44));
        obstacles.add(new Point(45, 46));
        Planet planet = new Planet(max, obstacles);
        Ship ship = new Ship(location, planet);

        Location expected = location.copy();
        expected.forward();
        ship.receiveCommands("f");
        assertEquals(ship.getLocation(), expected);
    }


    // book p.76
    @Test
    public void whenReceiveCommandsThenAllAreExecuted() {

        // https://bitbucket.org/vfarcic/tdd-java-ch04-ship/src/5b832a142fab70505af2d9e3c7896cc5079bce32/src/test/java/com/packtpublishing/tddjava/ch04ship/ShipSpec.java#lines-19
        Point max = new Point(50, 50);
        Location location = new Location(new Point(21, 13), Direction.NORTH);
        List<Point> obstacles = new ArrayList<>();
        obstacles.add(new Point(44, 44));
        obstacles.add(new Point(45, 46));
        Planet planet = new Planet(max, obstacles);
        Ship ship = new Ship(location, planet);

//        Point max = new Point(50, 50);
//        Location location = new Location(new Point(21, 13), Direction.NORTH);
//        Planet planet = new Planet(max);
//        Ship ship = new Ship(location, planet);

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

        // https://bitbucket.org/vfarcic/tdd-java-ch04-ship/src/5b832a142fab70505af2d9e3c7896cc5079bce32/src/test/java/com/packtpublishing/tddjava/ch04ship/ShipSpec.java#lines-19
        Point max = new Point(50, 50);
        Location location = new Location(new Point(21, 13), Direction.NORTH);
        List<Point> obstacles = new ArrayList<>();
        obstacles.add(new Point(44, 44));
        obstacles.add(new Point(45, 46));
        Planet planet = new Planet(max, obstacles);
        Ship ship = new Ship(location, planet);

//        Location location = new Location(new Point(21, 13), Direction.NORTH);
//
//        Point max = new Point(50, 50);
//        Planet planet = new Planet(max);
//        Ship ship = new Ship(location, planet);

        location.setDirection(Direction.EAST);
        location.getPoint().setX(planet.getMax().getX());
        ship.receiveCommands("f");
        assertEquals(location.getX(), 1);
    }

    @Test
    public void givenDirectionEAndXEquals1WhenReceiveCommandsBThenWrap() {

        // https://bitbucket.org/vfarcic/tdd-java-ch04-ship/src/5b832a142fab70505af2d9e3c7896cc5079bce32/src/test/java/com/packtpublishing/tddjava/ch04ship/ShipSpec.java#lines-19
        Point max = new Point(50, 50);
        Location location = new Location(new Point(21, 13), Direction.NORTH);
        List<Point> obstacles = new ArrayList<>();
        obstacles.add(new Point(44, 44));
        obstacles.add(new Point(45, 46));
        Planet planet = new Planet(max, obstacles);
        Ship ship = new Ship(location, planet);

//        Location location = new Location(new Point(21, 13), Direction.NORTH);
//
//        Point max = new Point(50, 50);
//        Planet planet = new Planet(max);
//        Ship ship = new Ship(location, planet);

        location.setDirection(Direction.EAST);
        location.getPoint().setX(1);
        ship.receiveCommands("b");
        assertEquals(location.getX(), planet.getMax().getX());
    }


    // book p.80
    // https://bitbucket.org/vfarcic/tdd-java-ch04-ship/src/5b832a142fab70505af2d9e3c7896cc5079bce32/src/test/java/com/packtpublishing/tddjava/ch04ship/ShipSpec.java#lines-133
    @Test
    public void whenReceiveCommandsThenStopOnObstacle() {

        Location location = new Location(new Point(21, 13), Direction.NORTH);

        Point max = new Point(50, 50);
        Planet planet = new Planet(max);
        Ship ship = new Ship(location, planet);

        List<Point> obstacles = new ArrayList<>();
        obstacles.add(new Point(location.getX() + 1, location.getY()));
        ship.getPlanet().setObstacles(obstacles);
        Location expected = location.copy();
        expected.turnRight();
        // Moving forward would encounter an obstacle
        // expected.forward(new Point(0, 0), new ArrayList<Point>());
        expected.turnLeft();
        expected.backward(new Point(0, 0), new ArrayList<>());
        ship.receiveCommands("rflb");
        assertEquals(ship.getLocation(), expected);
    }

    @Test
    public void whenReceiveCommandsThenOForOkAndXForObstacle() {

        // https://bitbucket.org/vfarcic/tdd-java-ch04-ship/src/5b832a142fab70505af2d9e3c7896cc5079bce32/src/test/java/com/packtpublishing/tddjava/ch04ship/ShipSpec.java#lines-19
        Point max = new Point(50, 50);
        Location location = new Location(new Point(21, 13), Direction.NORTH);
        //Planet planet = new Planet(max, obstacles);
        //Ship ship = new Ship(location, planet);
        Planet planet = new Planet(max);
        Ship ship = new Ship(location, planet);

        List<Point> obstacles = new ArrayList<>();
        obstacles.add(new Point(location.getX() + 1, location.getY()));
        ship.getPlanet().setObstacles(obstacles);
        String status = ship.receiveCommands("rflb");
        assertEquals(status, "OXOO");
    }

}