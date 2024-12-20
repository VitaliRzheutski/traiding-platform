package com.vitali.response;

import lombok.Data;

@Data
public class ApiResponse {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
}
