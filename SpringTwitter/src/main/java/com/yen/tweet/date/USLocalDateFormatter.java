package com.yen.tweet.date;

// p.66

//import com.sun.javafx.tools.packager.PackagerException;
//import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class USLocalDateFormatter implements Formatter<LocalDate> {
    public static final String US_PATTERN = "MM/dd/yyyy";
    public static final String NORMAL_PATTERN = "dd/MM/yyyy";

    @Override public LocalDate parse(String text, Locale locale) throws ParseException {
        return LocalDate.parse(text, DateTimeFormatter.ofPattern(getPattern(locale)));
    }

    public static String getPattern(Locale locale) {
        return isUnitedStates(locale) ? US_PATTERN : NORMAL_PATTERN;
    }

    private static boolean isUnitedStates(Locale locale){
        return Locale.US.getCountry().equals(locale.getCountry());
    }

    @Override
    public String print(LocalDate localDate, Locale locale) {
        return null;
    }
}
