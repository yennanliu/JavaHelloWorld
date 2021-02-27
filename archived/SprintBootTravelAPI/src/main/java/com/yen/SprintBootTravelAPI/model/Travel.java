package com.yen.SprintBootTravelAPI.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.yen.SprintBootTravelAPI.enumeration.TravelTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Travel {

    private Long id;
    private String orderNumber;
    private BigDecimal amount;
    private LocalDateTime startDate;
    private TravelTypeEnum type;

    public Travel(TravelTypeEnum type){
        this.type = type;
    }
}













