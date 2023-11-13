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

}
