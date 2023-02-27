package com.example.controller;
import com.alibaba.fastjson.JSON;
import com.example.entity.Project;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
@RestController
public class Donation
{
    Map<String,Object>map=new HashMap<>();

    @Autowired
    private UserService userService;

//注册操作
    @PostMapping("/donation")
    public String donation(String id, Double money)
    {
        map.put("code",200);
        map.put("msg","捐款成功");
        map.put("result",userService.donation(id,money));
        return JSON.toJSONString(map);
    }
}
