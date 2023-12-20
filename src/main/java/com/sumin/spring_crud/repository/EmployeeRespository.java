package com.sumin.spring_crud.repository;

import com.sumin.spring_crud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRespository extends JpaRepository<Employee,Long> {
}
