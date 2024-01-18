package com.example.demo.controller;

import com.example.demo.model.Staff;
import com.example.demo.model.StaffFile;
import com.example.demo.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/customers")
public class StaffController {
    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    private IStaffService iStaffService;
    @GetMapping("")
    public String show(Model model){
      model.addAttribute("staff",iStaffService.findAll());
      return "/Home";
    }
    @GetMapping("/create")
    public ModelAndView create(){
       ModelAndView modelAndView = new ModelAndView("/create");
modelAndView.addObject("staffFile",new StaffFile());
return modelAndView;
    }
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute StaffFile staffFile) {
        MultipartFile multipartFile = staffFile.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(staffFile.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Staff staff = new Staff(staffFile.getId(), staffFile.getName(),
                staffFile.getAge(),staffFile.getEmail(), fileName);
        iStaffService.save(staff);
//        ModelAndView modelAndView = new ModelAndView("/customers");
//        modelAndView.addObject("productForm", staff);
//        modelAndView.addObject("message", "Created new product successfully !");
        return "redirect:/customers";
    }


}
