package com.avalon.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avalon.service.sys.UserService;
import com.avalon.vo.Json;


@Controller
public class BaseController {
    @Autowired
    private UserService userService;
    
    @RequestMapping("/")
    public String home(HttpServletRequest request) {
        request.setAttribute("name","Avalon");
        return "hello";
    }
    
    @RequestMapping("/manager")
    public String manager(HttpServletRequest request) {
        //request.setAttribute("name","Avalon");
        return "manage";
    }
    
    
    @RequestMapping("/welcome")
    @ResponseBody
    public Json Welcome(String uid) {
        Json j=new Json(true,"ok",userService.getUserInfo(uid));
        return j;
    }
    
    
}
