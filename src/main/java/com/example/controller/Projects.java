package com.example.controller;

import com.example.entity.Project;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RestController
public class Projects
{
    Map<String,Object>map=new HashMap<>();

    @Autowired
    private UserService userService;

//返回目前的所有众筹项目(分页查询)
    @PostMapping("/projectList")
    public List<Project> projectList(Integer page)
    {
        return userService.showProjectList(page);
    }

//返回目前的所有众筹项目(全部)
    @GetMapping("/projectListAll")
    public List<Project> projectListAll()
    {
        return userService.showProjectListAll();
    }
}
