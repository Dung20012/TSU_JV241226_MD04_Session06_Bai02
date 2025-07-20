package com.data.session_06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin")
    public String adminPage(){
        return "admin-home"; // trả về file admin-home.jsp
    }
}
