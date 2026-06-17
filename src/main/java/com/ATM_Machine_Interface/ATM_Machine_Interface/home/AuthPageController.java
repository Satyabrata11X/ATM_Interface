package com.ATM_Machine_Interface.ATM_Machine_Interface.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthPageController {

    @GetMapping("/login-page")
    public String loginPage() {
        return "login";
    }
}