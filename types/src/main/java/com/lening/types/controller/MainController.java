package com.lening.types.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/main")
public class MainController {

    @RequestMapping("/tolist")
    public String toIndex(){
        return "goods_list";
    }


}
