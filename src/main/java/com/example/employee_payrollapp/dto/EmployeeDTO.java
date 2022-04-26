package com.example.employee_payrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data

public class EmployeeDTO {
    @Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Employee firstName is Invalid")
    private String firstName;

    @Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Employee lastName is Invalid")
    private String lastName;

    @NotEmpty(message = "ProfilePic cannot be null")
    private String profilePic;

    @NotEmpty(message = "Department name cannot be null")
    private List<String> department;

    @Min(value = 500, message = "Salary should be more than 500")
    private Long salary;

    @Pattern(regexp = "female|male ", message = "Gender needs to be male or female")
    private String gender;
    @JsonFormat(pattern="dd MMM yyyy")
    @NotNull (message = "startDate should Not be empty")
    @PastOrPresent(message = "Date should be past or today date")
    public LocalDate Date;
    private String notes;

    public EmployeeDTO() {
        super();
    }



}
