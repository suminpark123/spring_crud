package com.sumin.spring_crud.controller;


import com.sumin.spring_crud.model.Employee;
import com.sumin.spring_crud.repository.EmployeeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRespository employeeRespository;

    @GetMapping("all")
    public List<Employee> getAllEmployees(){
        return employeeRespository.findAll();
    }

}
