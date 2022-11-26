package com.example.aopdemo.util;

import lombok.Data;

import java.util.Collection;

@Data
public class CustomResponse<T> {

    private int code;

    private String message;

    private Collection<T> response;

    public CustomResponse(Collection<T> response, CustomStatus status) {
        this.code = status.getCode();
        this.message = status.getMessage();
        this.response = response;
    }
}
