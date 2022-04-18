package com.may.service;

import com.may.pojo.Employee;
import com.may.pojo.User;

import java.util.List;

public interface UserService {
    List<User> queryAll();

    List<User> query(User user);

    int addUser(User user);

    int deleteById(int id);

    int updateUser(User user);
}
