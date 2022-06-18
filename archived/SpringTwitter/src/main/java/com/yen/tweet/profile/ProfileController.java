package com.yen.tweet.profile;

// p.63
// https://github.com/Mastering-Spring-MVC-4/mastering-spring-mvc4/blob/chapter-3-forms/src/main/java/masterSpringMvc/profile/ProfileController.java

import com.yen.tweet.date.USLocalDateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;

@Controller
@RequestMapping("/")
//@RequestMapping(value = "/profile", params = {"save"}, method = RequestMethod.POST)
public class ProfileController {

    @ModelAttribute("dataFormat")
    public String localFormat(Locale locale) {
        return USLocalDateFormatter.getPattern(locale);
    }

    @RequestMapping("/profile")
    public String displayProfile(ProfileForm profileForm) {
        return "profile/profilePage";
    }

    @RequestMapping(value = "/profile", params = {"save"}, method=RequestMethod.POST)
    public String saveProfile(@Valid ProfileForm profileForm, BindingResult bindingResult){
        // save failed, back to profile page
        if (bindingResult.hasErrors()){
            return "profile/profilePage";
        }
        // save OK
        System.out.println("save OK " + profileForm);
        return "redirect/profile";
    }

    @RequestMapping(value = "/profile", params = {"addTaste"})
    public String addRow(ProfileForm profileForm){
        profileForm.getTastes().add(null);
        return "profile/profilePage";
    }

    @RequestMapping(value = "/profile", params = {"removeTaste"})
    public String removeRow(ProfileForm profileForm, HttpServletRequest req){
        Integer rowId = Integer.valueOf(req.getParameter("removeTaste"));
        profileForm.getTastes().remove(rowId.intValue());
        return "profile/profilePage";
    }
}
