package com.yen.TddPlayGround.ControllerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// https://github.com/sashinpivotal/spring-boot-tdd/blob/main/src/test/java/io/pivotal/workshop/CarControllerSliceTests.java

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ProductService productService;

    @Test
    public void testGetProductList() throws Exception {

        // https://stackoverflow.com/questions/53113052/is-there-any-other-way-to-put-parameter-of-mockmvc

        mockMvc.perform(
                get("/product/name")
                .param("name", "123"))
                .andExpect(status().isOk());
    }

    @Test
    public void getProductShouldReturnProduct() throws Exception {

        // mock service (productService.getProduct)
        when(productService.getProduct("iphone")).
                thenReturn(new Product("iphone", 100)
                );

        // Make request to controller through spring only.
        // This does not involve tomcat or any network call.
        ResultActions resultActions = mockMvc.perform(get("/product/name"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("iphone"))
                .andExpect(jsonPath("price").value(100));

        // TODO : fix below
        //verify(productService).getProduct("iphone");
    }

    @Test
    public void getProductNotFound() throws Exception {

        // mock service
        when(productService.getProduct("pixel")).
                thenThrow(new ProductNotFoundException()
                );

        ResultActions resultActions = mockMvc.perform(get("/product/pixel")) // NOTE the param (pixel) here !!!
                .andExpect(status().isNotFound());
    }


}