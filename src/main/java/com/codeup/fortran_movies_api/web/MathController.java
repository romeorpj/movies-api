package com.codeup.fortran_movies_api.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/{3}/and/{4}")
    @ResponseBody
    public int add(int num2, @PathVariable("3") String parameter){
        return num1 + num2;
    }

}
