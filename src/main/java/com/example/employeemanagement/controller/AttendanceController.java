package com.example.employeemanagement.controller;

import com.example.employeemanagement.dto.AttendanceRequestDto;
import com.example.employeemanagement.models.Attendance;
import com.example.employeemanagement.models.Employee;
import com.example.employeemanagement.service.AttendanceService;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class AttendanceController {
    @Autowired
   private AttendanceService attendanceService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/saveAttendance")
    public String markAttendance(HttpSession session){
       Employee employee= (Employee) session.getAttribute("user");
        System.out.println(employee);
       attendanceService.markAttendance(employee);
       return "redirect:/home";
    }

    @GetMapping(value = "/viewAttendanceList/{id}")
    public String viewAttendanceSheet(Model model,@PathVariable(name="id")int id){
        AttendanceRequestDto attendanceRequestDto= new AttendanceRequestDto();
        attendanceRequestDto.setEmployeeId(id);
        System.out.println(attendanceRequestDto.getEmployeeId());
        model.addAttribute("attendanceDisplayRequest",attendanceRequestDto);
        return "attendanceSheet";
    }

    @PostMapping(value ="/postAttendanceList" )
    public  String displayAttendanceSheet(@ModelAttribute("attendanceDisplayRequest")AttendanceRequestDto attendanceRequestDto, Model model, @RequestParam(value="id")int id){
        Employee employee= employeeService.findEmployee(id);
      LocalDate date1 = LocalDate.parse(attendanceRequestDto.getStartDate());
        LocalDate  date2 = LocalDate.parse(attendanceRequestDto.getEndDate());
        System.out.println(employee);
        List<Attendance> attendanceList=attendanceService.viewAttendanceList(date1,date2,employee);
        model.addAttribute("attendanceList",attendanceList);
        return "displayAttendance";
    }
}
