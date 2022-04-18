package com.may.controller;

import com.may.mapper.CompetenceMapper;
import com.may.mapper.DepartmentMapper;
import com.may.pojo.Competence;
import com.may.pojo.Department;
import com.may.pojo.Employee;
import com.may.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    CompetenceMapper competenceMapper;
    @Autowired
    DepartmentMapper departmentMapper;


    @GetMapping("/emps")
    public String emps(Model model) {
        List<Employee> employees = employeeService.queryAll();
        List<Competence> competences = competenceMapper.queryAll();
        List<Department> departments = departmentMapper.queryAll();
        model.addAttribute("competences", competences);
        model.addAttribute("departments", departments);
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAdd(Model model) {
        List<Competence> competences = competenceMapper.queryAll();
        List<Department> departments = departmentMapper.queryAll();
        model.addAttribute("competences", competences);
        model.addAttribute("departments", departments);
        return "/emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/emps";
    }

    @GetMapping("/updateEmp/{name}")
    public String toUpdate(@PathVariable("name") String name,Model model){
        Employee user = employeeService.queryByName(name);
        System.out.println("user ==>" + user);
        List<Competence> competences = competenceMapper.queryAll();
        List<Department> departments = departmentMapper.queryAll();
        model.addAttribute("user",user);
        model.addAttribute("competences", competences);
        model.addAttribute("departments", departments);
        return "/emp/update";
    }

    @PostMapping("/updateEmp")
    public String update(Employee employee){
        employeeService.updateEmployee(employee);
        System.out.println(employee +  "===> employee");
        return "redirect:/emps";
    }

    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable("id") int id){
        employeeService.deleteEmployeeById(id);
        return "redirect:/emps";
    }
}
