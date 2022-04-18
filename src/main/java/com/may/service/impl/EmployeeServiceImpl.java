package com.may.service.impl;

import com.may.mapper.EmployeeMapper;
import com.may.pojo.Employee;
import com.may.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<Employee> queryAll() {
        return employeeMapper.queryAll();
    }

    @Override
    public List<Employee> query(Employee employee) {
        return employeeMapper.query(employee);
    }

    @Override
    public int addEmployee(Employee employee) {
        return employeeMapper.addEmployee(employee);
    }

    @Override
    public int deleteEmployeeById(int id) {
        return employeeMapper.deleteEmployeeById(id);
    }

    @Override
    public int updateEmployee(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }

    public Employee queryByName(String name){
        return employeeMapper.queryByName(name);
    }
}
