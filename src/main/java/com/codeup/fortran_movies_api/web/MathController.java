package com.codeup.fortran_movies_api.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/{num1}/{num2}")
    @ResponseBody
    public int add(@PathVariable int num1, @PathVariable int num2){
        return num1 + num2;
    }
    @GetMapping("/subtract/{num3}/{num4}")
    @ResponseBody
    public int subtract(@PathVariable int num3, @PathVariable int num4){
        return num3 - num4;
    }
    @GetMapping("/multiply/{num3}/{num4}")
    @ResponseBody
    public int multiply(@PathVariable int num3, @PathVariable int num4){
        return num3 * num4;
    }
    @GetMapping("/divide/{num3}/{num4}")
    @ResponseBody
    public int divide(@PathVariable int num3, @PathVariable int num4){
        return num3 / num4;
    }
}
