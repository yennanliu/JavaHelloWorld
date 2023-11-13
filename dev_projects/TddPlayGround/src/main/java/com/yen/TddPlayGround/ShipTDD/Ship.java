package com.yen.TddPlayGround.ShipTDD;

// book Java测试驱动开发 p.66
// https://bitbucket.org/vfarcic/tdd-java-ch04-ship/src/req06-obstacles/src/main/java/com/packtpublishing/tddjava/ch04ship/Ship.java

public class Ship {

    private final Location location;

    public Ship(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return this.location;
    }

    public boolean moveForward() {
        /**
         *  NOTE : the logic we implement moveForward here:
         *
         *         Location expected = location.copy();
         *         expected.forward();
         *         ship.moveForward();
         *
         *        -> simply repeat what Location does to this method
         */
        return location.forward();
    }

    public boolean moveBackward() {

        // same as moveForward
        return location.backward();
    }

}
