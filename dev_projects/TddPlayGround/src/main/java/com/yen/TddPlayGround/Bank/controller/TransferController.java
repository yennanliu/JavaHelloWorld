package com.yen.TddPlayGround.Bank.controller;

import com.yen.TddPlayGround.Bank.bean.dto.DepositRequest;
import com.yen.TddPlayGround.Bank.bean.dto.TransferRequest;
import com.yen.TddPlayGround.Bank.bean.po.User;
import com.yen.TddPlayGround.Bank.repository.UserRepository;
import com.yen.TddPlayGround.Bank.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransferController {

    @Autowired
    TransferService transferService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/deposit/{id}")
    public int deposit(@PathVariable String id){

        System.out.println("(deposit) controller, id = " + id);

        try{
            //transferService.deposit(depositRequest.getUser(), depositRequest.getAmount());
            User user = userRepository.getById(id);
            transferService.deposit(user, 100.0);
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
