package com.example.employee_payrollapp.Controller;


import com.example.employee_payrollapp.Exception.EmployeePayrollException;
import com.example.employee_payrollapp.dto.EmployeeDTO;
import com.example.employee_payrollapp.dto.ResponseDTO;
import com.example.employee_payrollapp.model.Employee;
import com.example.employee_payrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping( "/employeePayrollService")
public class EmployeePayrollController {
    @Autowired
    IEmployeePayrollService service;

    @GetMapping("/getMessage")
    public ResponseEntity<String> getMessage(@RequestParam String name){
        String message = service.getMessage(name);
        return new ResponseEntity<String>(message,HttpStatus.OK);
    }
    @PostMapping("/postMessage")
    public ResponseEntity<String> postMessage(@Valid @RequestBody EmployeeDTO employeeDTO){
        String message = service.postMessage(employeeDTO);
        return new ResponseEntity<String>(message,HttpStatus.OK);
    }
    @PutMapping("/putMessage/{name}")
    public ResponseEntity<String> putMessage(@PathVariable String name){
        String message = service.putMessage(name);
        return new ResponseEntity<String>(message,HttpStatus.OK);
    }
    //Ability to display welcome message
    @GetMapping("")
    public ResponseEntity<String> getWelcome(){
        String welcome = service.getWelcome();
        return new ResponseEntity<String>(welcome,HttpStatus.OK);
    }
    //Ability to save employee data to repo
    @PostMapping("/create")
    public ResponseEntity<String> addDataToRepo(@Valid @RequestBody EmployeeDTO employeeDTO){
        Employee newEmployee = service.postDataToRepo(employeeDTO);
        ResponseDTO dto = new ResponseDTO("Record Added Succesfully",newEmployee);
        return new ResponseEntity(dto,HttpStatus.CREATED);
    }
    //Ability to get all employees' data by findAll() method
    @GetMapping("/get")
    public ResponseEntity<String>getAllDataFromRepo(){
        List<Employee> listOfEmployee = service.getAllData();
        ResponseDTO dto = new ResponseDTO("Record Retrieved Successfully", listOfEmployee);
        return new ResponseEntity(dto,HttpStatus.OK);
    }
    //Ability to get employee data by id
    @GetMapping("/get/{id}")
    public ResponseEntity<String> getDataFromRepoById(@PathVariable Integer id) throws EmployeePayrollException {
        Optional<Employee> existingEmployee = service.getDataById(id);
        ResponseDTO responseDTO = new ResponseDTO("Record for given ID Retrieved Successfully", existingEmployee);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    //Ability to update employee data for particular id
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateDataInRepo(@PathVariable Integer id,
                                                   @Valid @RequestBody EmployeeDTO employeeDTO)
            throws EmployeePayrollException {
        Employee updatedEmployee = service.updateDataById(id, employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Record for particular ID Updated Successfully", updatedEmployee);
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
    }

    //Ability to delete employee data for particular id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDataInRepo(@PathVariable Integer id) throws EmployeePayrollException {
        ResponseDTO responseDTO = new ResponseDTO
                ("Record for particular ID Deleted Successfully", service.deleteDataById(id));
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
    }
}
