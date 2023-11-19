package com.yen.TddPlayGround.Bank.bean;

public class User {
    private String id;
    private Double balance;

    public User(String id, Double balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", balance=" + balance +
                '}';
    }

}
