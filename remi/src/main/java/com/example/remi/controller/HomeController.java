package com.example.remi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"","/"})
    public String home(){
        return "home/home";
        //resources/templates/ 앞에 생략됨
    }


}
