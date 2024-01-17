package com.example.demo.controller;

import com.example.demo.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class StaffController {

    @Autowired
    private IStaffService iStaffService;
    @GetMapping("")
    public String show(Model model){
      model.addAttribute("staff",iStaffService.findAll());
      return "/Home";
    }
    @GetMapping("/a")
    public String showHello(){
        return "/hello";
    }
}
