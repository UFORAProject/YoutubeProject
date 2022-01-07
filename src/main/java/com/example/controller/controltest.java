package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/controltest")
public class controltest{
    @RequestMapping(method = RequestMethod.GET)
    public String test(Model model){
        System.out.println("texxxxxxxas");
        model.addAttribute("name","홍길동");
        return "test";
    }

}