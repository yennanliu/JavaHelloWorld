package com.yen.TddPlayGround.Bank.bean.dto;

import com.yen.TddPlayGround.Bank.bean.po.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class TransferRequest {

    private User sender;
    private User receiver;
    private Double amount;
}
