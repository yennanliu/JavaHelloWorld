package com.yen.TddPlayGround.ControllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// https://github.com/sashinpivotal/spring-boot-tdd/blob/main/src/test/java/io/pivotal/workshop/CarControllerSliceTests.java

@WebMvcTest(ProductController.class)
public class ProductControllerSliceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void getProductShouldReturnHttp200WithValidName() throws Exception {

        // mock service
        given(productService.getProduct(anyString())).willReturn(new Product("iphone", 100));

        // act & assert
        mockMvc.perform(get("/product/name"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("iphone"))
                .andExpect(jsonPath("price").value(100));

        // TODO : fix below
        // verify that dependency is invoked
        verify(productService, times(1)).getProduct(anyString());
    }


}
