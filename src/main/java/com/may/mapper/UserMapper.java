package com.may.mapper;

import com.may.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    List<User> queryAll();
    List<User> query(User user);
    int addUser(User user);
    int deleteById(int id);
    int updateUser(User user);
}
