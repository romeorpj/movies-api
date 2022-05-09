package com.codeup.fortran_movies_api.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/landingpage")
    @ResponseBody
    public String landingPage(){
        return "This is the landing page!";
    }


}

