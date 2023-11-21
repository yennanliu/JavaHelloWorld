package com.yen.TddPlayGround.Bank.controller;

import com.yen.TddPlayGround.Bank.bean.dto.DepositRequest;
import com.yen.TddPlayGround.Bank.bean.dto.TransferRequest;
import com.yen.TddPlayGround.Bank.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    @Autowired
    TransferService transferService;

    @PostMapping("/deposit")
    public int deposit(@RequestParam DepositRequest depositRequest){

        System.out.println("(deposit) controller, request = " + depositRequest.toString());

        try{
            transferService.deposit(depositRequest.getUser(), depositRequest.getAmount());
            return 200;
        }catch (Exception e){
            return 500;
        }
    }

    @PostMapping("/withdraw")
    public int withdraw(@RequestParam DepositRequest request){

        try{
            transferService.withdraw(request.getUser(), request.getAmount());
            return 200;
        }catch (Exception e){
            return 500;
        }
    }

    @PostMapping("/transfer")
    public int transfer(@RequestParam TransferRequest request){

        try{
            transferService.transfer(request.getSender(), request.getReceiver(), request.getAmount());
            return 200;
        }catch (Exception e){
            return 500;
        }
    }

}
