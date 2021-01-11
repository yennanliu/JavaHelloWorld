package com.yen.model;

// The POJO class

public class Product {
    private String id;
    private String name;

    // getter
    public String getId(){
        return id;
    }

    // setter
    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
