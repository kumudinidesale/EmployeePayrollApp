package com.example.employee_payrollapp.Exception;


import com.example.employee_payrollapp.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeePayrollExceptionalHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception){

        List<ObjectError> errorList=exception.getBindingResult().getAllErrors();
        List<String> errMesg = errorList.stream().map(objErr->objErr.getDefaultMessage()).collect(Collectors.toList());

        ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST requests",errMesg);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);

    }

}

