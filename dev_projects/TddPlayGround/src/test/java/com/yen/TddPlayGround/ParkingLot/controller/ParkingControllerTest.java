package com.yen.TddPlayGround.ParkingLot.controller;

import com.yen.TddPlayGround.ParkingLot.bean.ParkingLot;
import com.yen.TddPlayGround.ParkingLot.repository.ParkingLotRepository;
import com.yen.TddPlayGround.ParkingLot.service.Impl.A_ParkingLot;
import com.yen.TddPlayGround.ParkingLot.service.ParkingService;
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

import java.util.ArrayList;
import java.util.Optional;

//import static jdk.jfr.internal.jfc.model.Constraint.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


// NOTE !!! DON'T use below annotation when test controller
//@ExtendWith(MockitoExtension.class)
@WebMvcTest(ParkingController.class) // @WebMvcTest(ExampleController.class)
class ParkingControllerTest {

    @Autowired
    private MockMvc mockMvc;
//
//    @MockBean
//    ParkingService parkingService;

    // TODO : double check should use Autowired or MockBean ???
//    @Autowired
//    ParkingLotRepository parkingLotRepository;

    ParkingLot parkingLot_a;

    @BeforeEach
    public void before(){

        System.out.println("before");
        parkingLot_a = new ParkingLot("p-01", 2, new ArrayList<>());
    }

    @Test
    public void testHello() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/parking/hello")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("hello !!!"));
    }

//    @Test
//    public void testGetParkingLotSize(){
//
//        // mock
//        when(parkingLotRepository.findById(anyString()))
//                .thenReturn(Optional.ofNullable(parkingLot_a));
//
//    }

}