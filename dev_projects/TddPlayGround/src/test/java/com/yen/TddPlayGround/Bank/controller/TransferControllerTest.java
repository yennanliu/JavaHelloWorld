package com.yen.TddPlayGround.Bank.controller;

import com.yen.TddPlayGround.Bank.bean.dto.DepositRequest;
import com.yen.TddPlayGround.Bank.bean.dto.TransferRequest;
import com.yen.TddPlayGround.Bank.bean.dto.WithdrawRequest;
import com.yen.TddPlayGround.Bank.bean.po.User;
import com.yen.TddPlayGround.Bank.repository.UserRepository;
import com.yen.TddPlayGround.Bank.service.TransferService;
import com.yen.TddPlayGround.Bank.service.impl.TransferServiceImpl;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/** Unit test for TransferController */

@WebMvcTest(controllers = TransferController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class TransferControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransferService transferService;

    // TODO : double check this
    @Autowired
    private ObjectMapper objectMapper;

    private UserRepository userRepository;

    private TransferRequest transferRequest;

    private DepositRequest depositRequest;

    private WithdrawRequest withdrawRequest;

    private User u1;
    private User u2;

    @BeforeEach
    public void before(){
        System.out.println("setup ...");
        u1 = new User("id-01", 10.0);
        u2 = new User("id-02", 10.0);
    }

    @Test
    public void shouldReturn200IfDepositSuccess() throws Exception {

        // mock
        given(transferService
                .deposit(any(User.class), any(Double.class)))
                .willAnswer((invocation -> invocation.getArgument(0)));

        depositRequest = new DepositRequest(u1, 5.0);

        // run
        ResultActions response = mockMvc.perform(post("/deposit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(depositRequest))
        );

        System.out.println("response = " + response);

        // verify
        // TODO : fix below
        response.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.amount", CoreMatchers.is(depositRequest.getAmount())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user", CoreMatchers.is(depositRequest.getUser())));

    }

    @Test
    public void shouldReturn200IfTransferSuccess(){

    }

}