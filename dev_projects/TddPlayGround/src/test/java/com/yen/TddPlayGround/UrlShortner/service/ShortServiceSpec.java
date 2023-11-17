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

    private ShortService shortService;

    @BeforeEach
    public void before(){
        // TODO : mock below
        shortService = new ShortService();
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

        String input = "https://google.com";
        String res = shortService.split(input);
        assertEquals(res, "google.com");
    }

    @Test
    public void shouldSplitWithHttpInput(){

        String input = "http://yahoo.com";
        String res = shortService.split(input);
        assertEquals(res, "yahoo.com");
    }

}