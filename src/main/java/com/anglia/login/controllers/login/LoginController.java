package com.anglia.login.controllers.login;

import com.anglia.login.model.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/login")
public class LoginController {

    @PostMapping()
    public String login(@ModelAttribute("user") User user, HttpSession session){
        if(user.isUserSet()){
            session.setAttribute("user", user);
            return "redirect:/home";
        }else{
            return "login/login";
        }
    }

    @GetMapping()
    public String login(){
        return "login/login";
    }
}
