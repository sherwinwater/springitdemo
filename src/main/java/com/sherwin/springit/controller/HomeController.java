package com.sherwin.springit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @GetMapping("/about")
    public String home(Model model, HttpServletRequest request){
        model.addAttribute("msg","douluo dalu");
        System.out.println(request.getRequestedSessionId());
        return "index";
    }

}
