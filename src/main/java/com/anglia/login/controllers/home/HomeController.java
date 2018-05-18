package com.anglia.login.controllers.home;

import com.anglia.login.model.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = {"/", "/home"})
public class HomeController {

    @GetMapping()
    public String home(HttpSession s){
        User user = (User) s.getAttribute("user");
        if(user != null){
            return "home/home";
        }else{
            return "redirect:/login";
        }
    }

}
