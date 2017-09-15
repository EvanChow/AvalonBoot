package com.avalon.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avalon.vo.Json;

@Controller
public class BaseController {
    
    
    @RequestMapping("/")
    public String home(HttpServletRequest request) {
        request.setAttribute("name","Avalon");
        return "hello";
    }
    
    
    @RequestMapping("/welcome")
    @ResponseBody
    public Json Welcome() {
        Json j=new Json(true,"ok","成功");
        return j;
    }
    
    
}
