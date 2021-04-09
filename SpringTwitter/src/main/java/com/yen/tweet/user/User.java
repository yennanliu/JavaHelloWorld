package com.yen.tweet.user;

// p.136

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    // attr
    private String twitterHandle;
    private String email;
    private LocalDate birthDate;
    private List<String> tastes = new ArrayList<>();

    // constructor

    // getter, setter
    public String getTwitterHandle() {
        return twitterHandle;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<String> getTastes() {
        return tastes;
    }

    public void setTwitterHandle(String twitterHandle) {
        this.twitterHandle = twitterHandle;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setTastes(List<String> tastes) {
        this.tastes = tastes;
    }
}
