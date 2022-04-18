package com.may.mapper;

import com.may.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface EmployeeMapper {
    List<Employee> queryAll();
    List<Employee> query(Employee employee);
    Employee queryByName(String name);
    int addEmployee(Employee employee);

    int deleteEmployeeById(int id);
    int updateEmployee(Employee Employee);
}
