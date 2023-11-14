package com.yen.TddPlayGround.ShipTDD;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// https://bitbucket.org/vfarcic/tdd-java-ch04-ship/src/req06-obstacles/src/test/java/com/packtpublishing/tddjava/ch04ship/PlanetSpec.java

class PlanetSpec {

//    private Planet planet;
//    private final Point max = new Point(50, 50);
//    private List<Point> obstacles;
//
//    @BeforeTestMethod
//    public void beforeTest() {
//        obstacles = new ArrayList<Point>();
//        obstacles.add(new Point(12, 13));
//        obstacles.add(new Point(16, 32));
//        planet = new Planet(max, obstacles);
//    }

    @Test
    public void whenInstantiatedThenMaxIsSet(){

        Planet planet;
        final Point max = new Point(50, 50);
        List<Point> obstacles;

        obstacles = new ArrayList<Point>();
        obstacles.add(new Point(12, 13));
        obstacles.add(new Point(16, 32));
        planet = new Planet(max, obstacles);

        assertEquals(planet.getMax(), max);
    }

    @Test
    public void whenInstantiatedThenObstaclesAreSet(){

        Planet planet;
        final Point max = new Point(50, 50);
        List<Point> obstacles;

        obstacles = new ArrayList<Point>();
        obstacles.add(new Point(12, 13));
        obstacles.add(new Point(16, 32));
        planet = new Planet(max, obstacles);

        assertEquals(planet.getObstacles(), obstacles);
    }

}