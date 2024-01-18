package com.example.demo.controller;

import com.example.demo.model.Staff;
import com.example.demo.model.StaffFile;
import com.example.demo.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
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
    //show
    @GetMapping("")
    public String show(Model model){
      model.addAttribute("staff",iStaffService.findAll());
      return "/Home";
    }
    //xoa
    @GetMapping("/create")
    public ModelAndView create(){
       ModelAndView modelAndView = new ModelAndView("/create");
modelAndView.addObject("staffFile",new StaffFile());
return modelAndView;
    }

    //dung de luu anh va upload anh(xu li anh)
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
        return "redirect:/customers";
    }


    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id, Model model) {
        // Lấy thông tin khách hàng cần xóa
        Staff staff = iStaffService.getCustomerById(id);
        // Kiểm tra xem khách hàng có hình ảnh không
        if (staff != null && staff.getImage() != null) {
            // Xóa file ảnh từ thư mục
            String imagePath = "C:\\image\\" + staff.getImage();
            File imageFile = new File(imagePath);
            if (imageFile.exists()) {
                imageFile.delete();
            }
        }
        // Xóa khách hàng
        iStaffService.remote(id);
        // Chuyển hướng về trang danh sách khách hàng
        return "redirect:/customers";
    }



}
