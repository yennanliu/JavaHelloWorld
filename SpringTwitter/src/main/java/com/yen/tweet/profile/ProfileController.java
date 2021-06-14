package com.yen.tweet.profile;

// p.63

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
//@RequestMapping(value = "/profile", params = {"save"}, method = RequestMethod.POST)
public class ProfileController {
    @RequestMapping("/profile")
    public String displayProfile(ProfileForm profileForm) {
        return "profile/profilePage";
    }
}
