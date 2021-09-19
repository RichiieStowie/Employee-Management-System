package com.example.employeemanagement.controller;

import com.example.employeemanagement.models.Employee;
import com.example.employeemanagement.models.Leave;
import com.example.employeemanagement.models.enums.Status;
import com.example.employeemanagement.repositories.EmployeeRepository;
import com.example.employeemanagement.repositories.LeaveRepository;
import com.example.employeemanagement.service.EmployeeService;
import com.example.employeemanagement.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class LeaveApplicationController {
    @Autowired
    private EmployeeRepository employeeRepository;
   @Autowired
    private LeaveService leaveService;
   @Autowired
   private LeaveRepository leaveRepository;

   @GetMapping(value="/leaveRequest")
    public String getRequest(Model model){
       model.addAttribute("leaveApplication",new Leave());
       return "leaveApplicationForm";
   }

   @PostMapping(value ="/leavePost")
    public String postRequest(@ModelAttribute("leaveApplication") Leave leave, HttpSession session){
       leave.setStatus(Status.PENDING);
       Employee user= (Employee) session.getAttribute("user");
       leave.setEmployee(user);
       leaveService.RequestForLeave(leave);
       return "staffView";
   }

   @GetMapping(value = "/leaveStatus")
    public String displayStatusToStaff(Model model,HttpSession session){
       Employee employee= (Employee) session.getAttribute("user");
      System.out.println(employee);
       Leave leave=leaveService.displayLeaveStatus(employee.getId());
       model.addAttribute("requestStatus",leave.getStatus());
       return "statusForm";
   }

   @GetMapping (value="/home")
    public String returnHomePageOfStaff(){
       return "staffView";
   }


   @GetMapping(value = "/listOfApplicantsForleave")
    public String listOfApplicantsForLeave(Model model){
     List<Leave> leaveList=  leaveRepository.findLeavesByStatus(Status.PENDING);
     model.addAttribute("leaves",leaveList);
     Map<String,Leave>leaveMap= new HashMap<>();
         for (Leave leave:leaveList) {
          Employee user= employeeRepository.getById(leave.getEmployee().getId());
          leaveMap.put(user.getEmail(), leave);
         }
         model.addAttribute("leaveMap",leaveMap);
     return "leaveApplicants";
   }

   @GetMapping(value = "/acceptLeaveRequest/{id}")
    public String acceptLeaveRequest(@PathVariable(name = "id")int id){
     Leave leave=leaveRepository.getById(id);
     leave.setStatus(Status.SUCCESS);
     leaveRepository.save(leave);
     return "redirect:/listOfApplicantsForleave";
   }

    @GetMapping(value = "/RejectLeaveRequest/{id}")
    public String rejectLeaveRequest(@PathVariable(name = "id")int id){
        Leave leave=leaveRepository.getById(id);
        leave.setStatus(Status.REJECTED);
        leaveRepository.save(leave);
        return "redirect:/listOfApplicantsForleave";
    }
}
