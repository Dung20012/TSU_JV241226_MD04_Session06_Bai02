package com.data.session_06.controller;

import com.data.session_06.model.entity.UserSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("home")
    public String userPage(Model model){
        model.addAttribute("username", UserSession.customer.getUsername());
        return "home"; // trả về file user-home.jsp
    }
}
