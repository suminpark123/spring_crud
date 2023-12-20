package com.sumin.spring_crud.controller;


import com.sumin.spring_crud.exception.ResourceNotFoundException;
import com.sumin.spring_crud.model.Employee;
import com.sumin.spring_crud.repository.EmployeeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRespository employeeRespository;

    //전체데이터를 가져오는 api
    @GetMapping("all")
    public List<Employee> getAllEmployees(){
        return employeeRespository.findAll();
    }

    //데이터를 생성하는 api
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRespository.save(employee);

    }

    //상세데이터 가져오기
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee = employeeRespository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id:"+ id));
        return  ResponseEntity.ok(employee);
    }

    //상세데이터삭제 api
    @DeleteMapping("{id}")
    public  String delateEmployee(@PathVariable long id){
        Employee employee = employeeRespository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id:"+id));
        employeeRespository.delete(employee);
        return "Sucuess";
    }

    //상세데이터 수정하기
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable long id,
            @RequestBody Employee employeeData
    ){
        Employee employee = employeeRespository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id:"+id));
        employee.setFirstName(employeeData.getFirstName());
        employee.setLastName(employeeData.getLastName());
        employee.setEmail(employeeData.getEmail());

        employeeRespository.save(employee);
        return  ResponseEntity.ok(employee);
    }

}
