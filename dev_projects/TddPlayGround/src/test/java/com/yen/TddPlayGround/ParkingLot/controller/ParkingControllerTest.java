package com.yen.TddPlayGround.ParkingLot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yen.TddPlayGround.Bank.bean.po.User;
import com.yen.TddPlayGround.Bank.repository.UserRepository;
import com.yen.TddPlayGround.ParkingLot.ParkingLotApp;
import com.yen.TddPlayGround.ParkingLot.bean.HelloMsg;
import com.yen.TddPlayGround.ParkingLot.bean.ParkingLot;
import com.yen.TddPlayGround.ParkingLot.repository.ParkingLotRepository;
import com.yen.TddPlayGround.ParkingLot.service.Impl.A_ParkingLot;
import com.yen.TddPlayGround.ParkingLot.service.ParkingService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Optional;

//import static jdk.jfr.internal.jfc.model.Constraint.any;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.http.RequestEntity.post;
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
//    private ParkingLotRepository parkingLotRepository;
//    public void setParkingLotRepository(ParkingLotRepository parkingLotRepository){
//        this.parkingLotRepository = parkingLotRepository;
//    }

    @Mock
    ParkingLotRepository parkingLotRepository;

    @Autowired
    private ObjectMapper objectMapper;

    ParkingLot parkingLot_a;

    @BeforeEach
    public void before(){

        System.out.println("before");

        parkingLot_a = new ParkingLot("p-01", 2, new ArrayList<>());

        String PARKINGLOT_ID_A = "p-01";

        // mock // TODO : here we mock repository and service, check if it's correct / necessary
        Mockito.when(parkingLotRepository.findById(anyString()))
                .thenReturn(Optional.ofNullable(parkingLot_a));

        Mockito.when(parkingService.getById(PARKINGLOT_ID_A))
                .thenReturn(parkingLot_a);
    }

    @Test
    public void testHello() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/parking/hello")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("hello !!!"));
    }

    // TODO : fix below
//    @Test
//    public void testHello2() throws Exception {
//
//        HelloMsg helloMsg = new HelloMsg("iori", 17);
//
//
//        ResultActions response =  mockMvc.perform(
//                        post("/parking/hello2")
//                        .contentType(MediaType.APPLICATION_JSON).;
//
//        // verify
//        response.andExpect(status().isCreated());
////                .andExpect(MockMvcResultMatchers.jsonPath("$.name", CoreMatchers.is(helloMsg.getName())))
////                .andExpect(MockMvcResultMatchers.jsonPath("$.age", CoreMatchers.is(helloMsg.getAge())));
//    }

    @Test
    public void testGetParkingLotSize() throws Exception {

        String PARKINGLOT_ID_A = "p-01";

        // mock : we move all mock to before method

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/parking/size/" + PARKINGLOT_ID_A)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("size = 2"));
    }

    @Test
    public void testGetParkingLotFreeSpace() throws Exception {

        String PARKINGLOT_ID = "p-01";

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/parking/freeSpace/" + PARKINGLOT_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("free space size = 2"));
    }

    @Test
    public void shouldReturnTrueWhenParkSuccess() throws Exception {

        String PARKINGLOT_ID = "p-01";
        String CAR_ID = "c-01";

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/parking/park/" + PARKINGLOT_ID + "/" + CAR_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("park_car OK false"));
    }

}