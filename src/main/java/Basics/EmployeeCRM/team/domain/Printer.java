package Basics.EmployeeCRM.team.domain;

// https://www.youtube.com/watch?v=1vbROSe7c7Q&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=389

public class Printer implements Equipment{
    // attr
    private String name;
    private String type;

    // getter, setter
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    // constructor
    public Printer(){
        super();
    }

    public Printer(String name, String type){
        super();
        this.name = name;
        this.type = type;
    }

    // method
    @Override
    public String getDescription() {
        return name + " ( " + type + " )";
    }
}
