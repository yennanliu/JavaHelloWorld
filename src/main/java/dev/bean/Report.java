package dev.bean;

public class Report{

    // attr
    String name;
    String id;
    Integer value1;
    Double value2;

    // constructor
    public Report() {

    }

    public Report(String name, String id, Integer value1, Double value2) {
        this.name = name;
        this.id = id;
        this.value1 = value1;
        this.value2 = value2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getValue1() {
        return value1;
    }

    public void setValue1(Integer value1) {
        this.value1 = value1;
    }

    public Double getValue2() {
        return value2;
    }

    public void setValue2(Double value2) {
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return "Report{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", value1=" + value1 +
                ", value2=" + value2 +
                '}';
    }

}