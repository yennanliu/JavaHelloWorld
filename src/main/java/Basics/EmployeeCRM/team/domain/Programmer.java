package Basics.EmployeeCRM.team.domain;

// https://www.youtube.com/watch?v=rN0byZHtGw8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=390

import Basics.EmployeeCRM.team.service.Status;

public class Programmer extends Employee{

    // attr
    private int memberId;   // dev team id
    // NOTE : Status here is user defined
    private Status status;  // employee status : BUSY, FREE, VOCATION...
    private Equipment equipment;

    // getter, setter
    public int getMemberId() {
        return memberId;
    }

    public Status getStatus() {
        return status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    // constructor
    public Programmer(){
        super();
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment){
        // NOTE here
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    // method
}