package com.example.employeemanagement.controller;

import com.example.employeemanagement.models.Employee;
import com.example.employeemanagement.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Slf4j
public class AdminController {
    @Autowired
    private EmployeeService employeeService;


    @GetMapping(value = "/newEmployee")
    public ModelAndView showNewEmployeeForm(){
        Employee employee= new Employee();
        ModelAndView modelAndView= new ModelAndView("newEmployeeForm");
        modelAndView.addObject("employee",employee);
        return modelAndView;
    }
    @PostMapping(value = "/newEmployee")
    public String addNewEmployee(@ModelAttribute("employee")Employee employee, Model model){
        System.out.println(employee);
        employeeService.CreateNewEmployee(employee);

        return "redirect:/viewList";
    }
    @GetMapping("/viewList")
    public String viewAllEmployees(Model model){
        List<Employee> employeeList= employeeService.findAllEmployee();
        model.addAttribute("listOfEmployees",employeeList);
        return "adminView";
    }
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id")int id){
        employeeService.deleteEmployee(id);
        return "redirect:/viewList";
    }

    @GetMapping("/paySalary/{id}")
    public String paySalary(@PathVariable(value = "id") int id){
        employeeService.paySalaryByEmployeeId(id);
        return "redirect:/viewList";
    }

}
