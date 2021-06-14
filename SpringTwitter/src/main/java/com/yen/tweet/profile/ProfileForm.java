package com.yen.tweet.profile;

// p. 63

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProfileForm {
    // attr
    private String TwitterHandle;
    private String email;
    private LocalDate birthDate;
    private List<String> tastes = new ArrayList<>();

    // getter setter
    public String getTwitterHandle() {
        return TwitterHandle;
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
        TwitterHandle = twitterHandle;
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
