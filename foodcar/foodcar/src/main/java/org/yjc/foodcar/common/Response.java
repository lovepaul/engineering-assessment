package org.yjc.foodcar.common;


import lombok.Data;

@Data
public class Response<T> {
    private String code;
    private String message;
    private T data;

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setCode("200");
        response.setMessage("Ready");
        response.setData(data);
        return response;
    }

    public static <T> Response<T> failure(String message) {
        Response<T> response = new Response<>();
        response.setCode("500");
        response.setMessage(message);
        response.setData(null);
        return response;
    }
}
