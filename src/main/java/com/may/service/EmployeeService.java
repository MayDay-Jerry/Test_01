package com.may.service;

import com.may.mapper.EmployeeMapper;
import com.may.pojo.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    List<Employee> queryAll();

    List<Employee> query(Employee employee);

    int addEmployee(Employee employee);

    int deleteEmployeeById(int id);

    int updateEmployee(Employee employee);

    Employee queryByName(String name);
}
