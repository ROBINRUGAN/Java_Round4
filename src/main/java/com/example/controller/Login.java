package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.entity.Account;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
@RestController
public class Login
{
    Map<String,Object>map=new HashMap<>();
    static Account user;
    @Autowired
    private UserService userService;

//登录操作
    @GetMapping("/login")
    public String login(String username,String password)
    {
        user = userService.getAccount(username);
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password))
        {
            map.clear();
            map.put("code",404);
            map.put("msg","账号或密码不能为空！");
            return JSON.toJSONString(map);
        }
        if(user==null)
        {
            map.clear();
            map.put("code",404);
            map.put("msg","用户不存在！");
            return JSON.toJSONString(map);
        }
        else
        {
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
            {
                map.clear();
                map.put("code",200);
                map.put("msg","登陆成功");
                map.put("result",user);
                return JSON.toJSONString(map);
            }
            else
            {
                map.clear();
                map.put("code",404);
                map.put("msg","账号或密码错误！");
                return JSON.toJSONString(map);
            }
        }
    }
}
