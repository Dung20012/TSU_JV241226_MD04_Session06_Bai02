package com.data.session_06.controller;

import com.data.session_06.model.entity.Customer;
import com.data.session_06.model.entity.UserSession;
import com.data.session_06.model.service.Impl.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

    @PostMapping("/login")
    public String processLoginForm(@RequestParam String username,
                                   @RequestParam String password,
                                   Model model){
        if (username.isEmpty() || password.isEmpty()){
            model.addAttribute("error", " Không được để trống !");
            return "login";
        }

        Customer customer = customerService.login(username, password);
        if (customer == null){
            model.addAttribute("error", "Sai tài khoản hoặc mật khẩu !");
            return "login";
        }

        UserSession.customer = customer;
        if (customer.getRole() == Customer.Role.ADMIN){
            return "redirect:/admin";
        }else {
            return "redirect:/user";
        }
    }
}
