package com.may.controller;

import com.may.pojo.Competence;
import com.may.pojo.Department;
import com.may.pojo.Employee;
import com.may.pojo.User;
import com.may.service.UserService;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller()
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/list")
    public String emps(Model model) {
        List<User> users = userService.queryAll();
        model.addAttribute("users", users);
        return "user/list";
    }

    @GetMapping("/add")
    public String toAdd(){
        return "/user/add";
    }

    @PostMapping("/add")
    public String add(User user){
        userService.addUser(user);
        return "redirect:/user/list";
    }

    @GetMapping("/update/{id}")
    public String toUpdate(@PathVariable("id") Integer id,Model model){
        User tempUser = new User();
        tempUser.setId(id);
        List<User> users = userService.query(tempUser);
        model.addAttribute("users",users);
        return "/user/update";
    }

    @PostMapping("/update")
    public String update(User user){
        System.out.println("user ==>" + user);
        userService.updateUser(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id")Integer id) {
        userService.deleteById(id);
        return "redirect:/user/list";
    }
}
