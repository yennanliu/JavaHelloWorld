package com.yen.TddPlayGround.ControllerMockTest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.ALWAYS)
@Getter
public class Response<T> implements Serializable {

    private static String RESULT_SUCCESS = "RESULT_SUCCESS";
    private static String DEFAULT_SUCCESS_MESSAGE = "DEFAULT_SUCCESS_MESSAGE";

    @JsonProperty("Result")
    private String code;

    @JsonProperty("Message")
    private String message;

    @Setter
    @JsonProperty("Data")
    private T data;
    private String result;

    private Response() {}

    public static Response<Void> success(String userInfo) {
        Response<Void> res = new Response<>();
        res.result = RESULT_SUCCESS;
        res.message = DEFAULT_SUCCESS_MESSAGE;
        res.data = null;
        return res;
    }

//    public static <T extends ResponsePayload> Response<T> success(T data) {
//        Response<T> res = new Response<>();
//        res.result = RESULT_SUCCESS;
//        res.message = DEFAULT_SUCCESS_MESSAGE;
//        res.data = data;
//        return res;
//    }

    public static Response<Void> fail(ErrorCode errorCode, String message) {
        Response<Void> res = new Response<>();
        //res.result = errorCodeToResult(errorCode);
        res.message = message;
        res.data = null;
        return res;
    }

    public static Response<Void> fail(BaseException e) {
        return fail(e.getCode(), e.getMessage());
    }

}