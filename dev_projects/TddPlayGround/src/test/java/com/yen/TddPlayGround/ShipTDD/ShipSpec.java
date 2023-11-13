package com.yen.TddPlayGround.ShipTDD;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/** test class for Ship */
// book p.70

class ShipSpec {

    @Test
    public void whenInstantiatedThenLocationIsSet() {
        Location location = new Location(
                new Point(21, 13), Direction.NORTH);
        Ship ship = new Ship(location);
        assertEquals(ship.getLocation(), location);
    }


}