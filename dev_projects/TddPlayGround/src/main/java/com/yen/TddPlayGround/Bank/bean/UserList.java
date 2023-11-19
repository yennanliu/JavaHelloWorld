package com.yen.TddPlayGround.Bank.bean;

import java.util.List;

public class UserList {

    private List<User> userList;

    public UserList(){

    }

    public UserList(List<User> userList){
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "UserList{" +
                "userList=" + userList +
                '}';
    }

}
