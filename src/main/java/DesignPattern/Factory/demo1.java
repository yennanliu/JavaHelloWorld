package DesignPattern.Factory;

// https://www.runoob.com/design-pattern/factory-pattern.html

interface Vehicle{
    void drive();
}

class Toyota implements Vehicle{

    @Override
    public void drive() {
        System.out.println("Toyota drive");
    }
}

class Lexus implements Vehicle{

    @Override
    public void drive() {
        System.out.println("Lexus drive");
    }
}

class CarFactory{

    // attr
    private Vehicle vehicle;

    // constructor
    public CarFactory(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public void run(){
        System.out.println(">>> this.vehicle = " + this.vehicle.getClass());
        // TODO : optimize with switch-case
        if (Toyota.class.equals(this.vehicle.getClass())) {
            System.out.println("this is a Toyota car");
            vehicle.drive();
            //return this.vehicle;
        } else if (Lexus.class.equals(this.vehicle.getClass())) {
            System.out.println("this is a Lexus car");
            vehicle.drive();
        }else {
            System.out.println("this is a default car");
        }
    }

}

public class demo1 {

    public static void main(String[] args) {

        Toyota toyota_car = new Toyota();
        Lexus lexus_car = new Lexus();

        CarFactory carFactory_1 = new CarFactory(toyota_car);
        CarFactory carFactory_2 = new CarFactory(lexus_car);

        carFactory_1.run();
        carFactory_2.run();
    }

}
