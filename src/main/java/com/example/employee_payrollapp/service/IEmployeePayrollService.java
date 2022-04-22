package com.example.employee_payrollapp.service;


import com.example.employee_payrollapp.model.User;


public interface IEmployeePayrollService {

    public String getMessage(String name) ;
    public String postMessage(User employee);
    public String putMessage(String name) ;

}
