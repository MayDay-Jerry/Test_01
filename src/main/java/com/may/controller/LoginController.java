package com.may.controller;

import com.may.mapper.EmployeeMapper;
import com.may.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    EmployeeMapper employeeMapper;

    @PostMapping("/err")
    public String error(String name, Model model) {
        Employee user = employeeMapper.queryByName(name);
        model.addAttribute("msg", "用户名或密码错误");
        if (user == null) {
            model.addAttribute("msg", "用户名不存在");
        }
        return "index";
    }
}
