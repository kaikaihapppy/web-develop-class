package com.example.one.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

public class CSRFController {
    //向用户修改页跳转
    @GetMapping("/toUpdate")
    public String toUpdate(){
        return "csrf/csrfTest";
    }
    //用户修改提交处理
    @ResponseBody
    @PostMapping(value = "/updateUser")
    public String updateUser(@RequestParam String username , @RequestParam String password , HttpServletRequest request){
        System.out.println(username);
        System.out.println(password);
        String csrf_token = request.getParameter("_csrf");
        System.out.println(csrf_token);
        return "ok";
    }
}
