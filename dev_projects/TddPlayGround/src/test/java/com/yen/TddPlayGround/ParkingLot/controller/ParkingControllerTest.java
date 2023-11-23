package com.yen.TddPlayGround.ParkingLot.controller;

import com.yen.TddPlayGround.ParkingLot.ParkingLotApp;
import com.yen.TddPlayGround.ParkingLot.bean.ParkingLot;
import com.yen.TddPlayGround.ParkingLot.repository.ParkingLotRepository;
import com.yen.TddPlayGround.ParkingLot.service.Impl.A_ParkingLot;
import com.yen.TddPlayGround.ParkingLot.service.ParkingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
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

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes= ParkingLotApp.class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@WebMvcTest(ParkingController.class) // @WebMvcTest(ExampleController.class)
class ParkingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ParkingService parkingService;

    // TODO : double check should use Autowired or MockBean ???
    //@Autowired
    // https://blog.csdn.net/json8888/article/details/121638428
    private ParkingLotRepository parkingLotRepository;
    public void setParkingLotRepository(ParkingLotRepository parkingLotRepository){
        this.parkingLotRepository = parkingLotRepository;
    }

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
//    public void testGetParkingLotSize() throws Exception {
//
//        // mock
//        when(parkingLotRepository.findById(anyString()))
//                .thenReturn(Optional.ofNullable(parkingLot_a));
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/parking/parkSize/p-01")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().string("hello !!!"));
//
//    }

}