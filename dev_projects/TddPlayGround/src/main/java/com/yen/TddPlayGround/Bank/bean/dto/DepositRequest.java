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
public class DepositRequest {

    private User user;
    private Double amount;
}
