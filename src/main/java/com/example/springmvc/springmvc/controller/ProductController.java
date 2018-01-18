package com.example.springmvc.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mpumelelomashabane on 15/01/2018.
 */

@Controller
public class ProductController {

    @RequestMapping(path = "/")
    public String index(){
        return "index";
    }

}
