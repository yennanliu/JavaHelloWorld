package com.yen.TddPlayGround.ControllerMockTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BaseException {

    private ErrorCode code;
    private String message;
}
