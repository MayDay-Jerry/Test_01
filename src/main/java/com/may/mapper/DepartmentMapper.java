package com.may.mapper;


import com.may.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DepartmentMapper {
    List<Department> queryAll();
    Department query(int id);
}
