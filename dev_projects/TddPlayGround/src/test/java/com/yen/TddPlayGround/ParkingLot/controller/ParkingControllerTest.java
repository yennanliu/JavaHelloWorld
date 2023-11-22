package com.yen.TddPlayGround.ParkingLot.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


// NOTE !!! DON'T use below annotation when test controller
//@ExtendWith(MockitoExtension.class)
@WebMvcTest(ParkingController.class) // @WebMvcTest(ExampleController.class)
class ParkingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void before(){
        System.out.println("before");
    }

    @Test
    public void testHello() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/parking/hello")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("hello !!!"));
    }

}