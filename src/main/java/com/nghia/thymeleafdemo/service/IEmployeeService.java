package com.nghia.thymeleafdemo.service;

import com.nghia.thymeleafdemo.entity.Employee;
import com.nghia.thymeleafdemo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    Employee addEmployee(Employee employee);
}
