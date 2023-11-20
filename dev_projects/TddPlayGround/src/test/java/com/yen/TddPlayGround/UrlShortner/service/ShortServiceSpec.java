package com.yen.TddPlayGround.UrlShortner.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/** Unit test for ShortService */

@ExtendWith(MockitoExtension.class)
class ShortServiceSpec {

    private String header;

    private ShortService shortService;

    String input1;

    String input2;

    @BeforeEach
    public void before(){

        // TODO : mock below
        shortService = new ShortService();
        header = "https://yen_shortner";
        input1 = "https://google.com";
        input2 = "http://yahoo.com";
    }

    @Test
    public void inputNullShouldReturnFalse(){

        boolean res = shortService.verify(null);
        assertEquals(res, false);
    }

    @Test
    public void inputNotNullShouldReturnTrue(){

        boolean res = shortService.verify("some_url");
        //assertNotNull(res);
        assertEquals(res, true);
    }

    @Test
    public void shouldSplitWithHttpsInput(){

        String res = shortService.split(input1);
        assertEquals(res, "google.com");
    }

    @Test
    public void shouldSplitWithHttpInput(){

        String res = shortService.split(input2);
        assertEquals(res, "yahoo.com");
    }

    @Test
    public void shouldReturnHashCodeWithNormalInput(){

        String res = shortService.shortener(input1);//"https://yen_shortner/wfwergere";
        assertTrue(res.contains(header));
    }


    @Test
    public void shouldReturnSameWhenSameInput(){

        String input1_ = "https://google.com";
        //System.out.println("res1 = " + shortService.shortener(input1));
        assertEquals(shortService.shortener(input1), shortService.shortener(input1_));
    }

    @Test
    public void shouldReturnDifferentWhenDifferentInput(){

        assertNotEquals(shortService.shortener(input1), shortService.shortener(input2));
    }

    @Test
    public void shouldReturnOriginalURLWhenInverse(){

        String res = shortService.shortener(input1);
        //System.out.println("res1 = " + shortService.shortener(input1));
        // inverse
        assertEquals(shortService.inverse(res), input1);

        String res2 = shortService.shortener(input2);
        //System.out.println("input2 inverse = " + shortService.inverse(res2));
        assertEquals(shortService.inverse(res2), input2);
    }

}