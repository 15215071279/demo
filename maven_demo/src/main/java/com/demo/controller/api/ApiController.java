package com.demo.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApiController {

    @RequestMapping(value="/api/apiRest", method={RequestMethod.POST})
    public String apiRest(){
        return "apiRest";
    }

    @RequestMapping(value="/api/web/welcome", method={RequestMethod.GET})
    public String apiWeb(){
        return "welcome";
    }

}
