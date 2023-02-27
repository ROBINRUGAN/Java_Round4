package com.example.controller;

import com.example.entity.Project;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController

public class DetailInfo
{
    @Autowired
    private UserService userService;
    Map<String,Object> map=new HashMap<>();
    @PostMapping("/detailInfo")
    @ResponseBody
    public Project detailInfo(String id)
    {
        return userService.detailInfo(id);
    }

}
