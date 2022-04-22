package com.example.employee_payrollapp.Controller;




import com.example.employee_payrollapp.model.User;
import com.example.employee_payrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeePayrollController {
    @Autowired
    IEmployeePayrollService service;

    @GetMapping("/getMessage")
    public ResponseEntity<String> getMessage(@RequestParam String name) {
        return new ResponseEntity<String>(service.getMessage(name), HttpStatus.OK);
    }

    @PostMapping("/postMessage")
    public ResponseEntity<User> postMessage(@RequestBody User employee) {
        return new ResponseEntity<User>(service.postMessage(employee), HttpStatus.OK);
    }

    //ability to display welcome message
    @GetMapping("/employeePayrollService")
    public ResponseEntity<String> getWelcome() {
        return new ResponseEntity<String>(service.getWelcome(), HttpStatus.OK);
    }

    //ability to save employee details to repository
    @PostMapping("/employeePayrollService/create")
    public ResponseEntity<User> saveDataToRepo(@RequestBody User employee) {
        return new ResponseEntity<User>(service.postDataToRepo(employee), HttpStatus.OK);
    }

    //ability to get all employees' data by findAll() method
    @GetMapping("/employeePayrollService/get")
    public ResponseEntity<List<User>> getAllDataFromRepo() {
        return new ResponseEntity<List<User>>(service.getAllData(), HttpStatus.OK);
    }

    //ability to get employee data by id
    @GetMapping("/employeePayrollService/get/{id}")
    public ResponseEntity<Optional<User>> getDataFromRepoById(@PathVariable Integer id) {
        return new ResponseEntity<Optional<User>>(service.getDataById(id), HttpStatus.OK);
    }

    //ability to update employee data for particular id
    @PutMapping("/employeePayrollService/update/{id}")
    public ResponseEntity<User> updateDataInRepo(@PathVariable Integer id, @RequestBody User employee) {
        return new ResponseEntity<User>(service.updateDataById(id, employee), HttpStatus.OK);
    }
}
