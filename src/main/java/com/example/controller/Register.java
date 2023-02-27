package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.entity.Account;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
@RestController
public class Register
{
    Map<String,Object>map=new HashMap<>();

    @Autowired
    private UserService userService;

//注册操作
    @PostMapping("/register")
    public String register(String username,String password,String email,String identity)
    {
        Account user = userService.getAccount(username);
        if(user!=null)
        {
            map.put("code",404);
            map.put("msg","账号已存在！");
            return JSON.toJSONString(map);
        }
        else
        {
            Account newUser = new Account(username,password,email,"user");
            userService.addAccount(newUser);
            map.put("code",200);
            map.put("msg","注册成功！");
            map.put("result",newUser);
            return JSON.toJSONString(map);
        }
    }
}
