package com.example.controller;

import com.example.entity.Project;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class PersonalList
{
    @Autowired
    private UserService userService;
    Map<String,Object> map=new HashMap<>();
    @PostMapping("/personalList")
    @ResponseBody
    public List<Project> detailList(String account)
    {
       return userService.detailList(account);
    }
}
