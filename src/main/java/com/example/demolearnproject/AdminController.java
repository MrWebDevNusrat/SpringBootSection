package com.example.demolearnproject;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
//    @PreAuthorize("hasRole(ApplicationUser.ADMIN.name())")
    public String adminDashboard(){
        return "admin/dashboard";

    }

}
