package ru.exception.com.springboot;

import lombok.Data;

@Data
public class ResponseBodyException  {

    public static final ResponseBodyException SUCCESS_RESPONSE_BODY = new ResponseBodyException();

    private final String success = "success";
    private final String error = "error";
    private final String exception = "exception";
}
