package com.example.employee_payrollapp.dto;


import lombok.Data;

public @Data class ResponseDTO {
    private String messsage;
    private Object data;

    public ResponseDTO(String messsage, Object data) {
        super();
        this.messsage = messsage;
        this.data = data;
    }
}

