package com.yen.TddPlayGround.Bank.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.yen.TddPlayGround.Bank.service.ExampleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ExampleController.class)
public class ExampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExampleService exampleService;

    @BeforeEach
    public void before(){
        System.out.println("before");
    }

    // Test GET endpoint
    @Test
    public void testSayHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/example/hello")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, Spring Boot!"));
    }

    // Test POST endpoint
    @Test
    public void testSayHello2() throws Exception {
        // Mock the behavior of the ExampleService
        when(exampleService.getGreeting()).thenReturn("Mocked Greeting");

        // Perform the GET request
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/example/hello2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Mocked Greeting"));
    }

}
