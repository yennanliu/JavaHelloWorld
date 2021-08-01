package Basics.EmployeeCRM.team.domain;

// https://www.youtube.com/watch?v=rN0byZHtGw8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=390

/** Designer class */
public class Designer extends Programmer{

    // attr
    private double bonus;

    // getter, setter
    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    // constructor
    public Designer(){

    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus){
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    // method
    @Override
    public String toString() {
        return super.getDetails() +
                " status=" + getStatus() +
                " bonus=" + bonus; //super.getEquipment().getDescription(); // TODO : fix this
    }
}
