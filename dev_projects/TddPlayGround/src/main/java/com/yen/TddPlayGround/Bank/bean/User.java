package com.yen.TddPlayGround.Bank.bean;

public class User {

    // attr
    private String id;
    private Double balance = 0.0; // float VS double : https://yubin551.gitbook.io/java-note/basic_java_programming/datatype/primitivedatatypes

    // constructor
    public User(){

    }

    public User(String id, Double balance){

        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getBalance() {

        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public double updateBalance(Double balance) {
        System.out.println("(User) updateBalance ...");
        this.balance = balance;
        return this.balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", balance=" + balance +
                '}';
    }

}
