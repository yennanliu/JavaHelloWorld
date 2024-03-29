package com.yen.TddPlayGround.ShipTDD;

// book Java测试驱动开发 p.66
// https://bitbucket.org/vfarcic/tdd-java-ch04-ship/src/req06-obstacles/src/main/java/com/packtpublishing/tddjava/ch04ship/Ship.java

public class Ship {

    private final Location location;

    private Planet planet;

    public Ship(Location location) {
        this.location = location;
    }

    public Ship(Location location, Planet planet) {
        this.location = location;
        this.planet = planet;
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
        //return location.forward();
        // book p.80
        //return location.forward(planet.getMax());
        // https://bitbucket.org/vfarcic/tdd-java-ch04-ship/src/5b832a142fab70505af2d9e3c7896cc5079bce32/src/main/java/com/packtpublishing/tddjava/ch04ship/Ship.java#lines-25
        return location.forward(planet.getMax(), planet.getObstacles());
    }

    public boolean moveBackward() {

        // same as moveForward
        //return location.backward();
        return location.backward(planet.getMax(), planet.getObstacles());
    }

    public void turnLeft() {

        location.turnLeft();
    }

    public void turnRight() {

        location.turnRight();
    }

    // l : left, r : right, f : forward, b : back
    public String receiveCommands(String commands) {

        StringBuilder output = new StringBuilder();

        for (char cmd : commands.toCharArray()){
            boolean status = true;
            System.out.println("_cmd = " + cmd);
            switch (cmd){
                case 'l':
                    turnLeft();
                    break;
                case 'r':
                    turnRight();
                    break;
                case 'f':
                    status = moveForward();
                    break;
                case 'b':
                    status = moveBackward();
                    break;
            }

            if (status){
                output.append('O');
            }else{
                output.append('X');
            }
        }
        return output.toString();
    }

    public Planet getPlanet() {
        return planet;
    }

}
