package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {

    @RequestMapping("/welcome")
    public String jspIndex(){
        System.out.println("--------------------into jspIndex------------------------");
        return "welcome";
    }

}
