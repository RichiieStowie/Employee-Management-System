package com.example.employeemanagement.controller;

import com.example.employeemanagement.dto.LoginDto;
import com.example.employeemanagement.models.Employee;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
  private EmployeeService employeeService;

    @GetMapping(value = "/")
    public String employeeLogin(Model model){
        model.addAttribute("employeeLogin", new LoginDto());
        return "index";
    }

    @PostMapping(value = "/login")
    public String employeeLogin(@ModelAttribute("employeeLogin") LoginDto loginDto, HttpSession session,Model model){
        System.out.println("I'm here right now");
        System.out.println(loginDto);
        String view="";
        Employee user=employeeService.getEmployeeByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
        System.out.println(user);
        if(user!=null){


            if(user.getRole().equalsIgnoreCase("admin")){
                session.setAttribute("user",user);
                view= "redirect:viewList";
            }
            else if(user.getRole().equalsIgnoreCase("staff")){
                session.setAttribute("user",user);
                model.addAttribute("staff",user);
                view= "staffView";
            }
        }

       return view;
    }

    @GetMapping(value = "/logOut")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
