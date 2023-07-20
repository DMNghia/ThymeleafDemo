package com.nghia.thymeleafdemo.cntroller;

import com.nghia.thymeleafdemo.entity.Employee;
import com.nghia.thymeleafdemo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@Controller
public class EmployeeController {

    @Autowired
    private IEmployeeService service;

    @GetMapping({"/employees", "/", "/list"})
    public ModelAndView showEmployees() {
        ModelAndView mav = new ModelAndView("list-employees");
        List<Employee> list = service.findAll();
        mav.addObject("employees", list);
        return mav;
    }

    @GetMapping("/newEmployee")
    public ModelAndView addEmployee() {
        ModelAndView mav = new ModelAndView("new-employees");
        Employee newEmployee = new Employee();
        mav.addObject("employee", newEmployee);
        return mav;
    }

    @PostMapping("/newEmployee")
    public String addEmployee(@ModelAttribute Employee employee) {
        service.addEmployee(employee);
        return "redirect:/employees";
    }
}
