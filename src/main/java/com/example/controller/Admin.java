package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
public class Admin
{
    Map<String,Object> map=new HashMap<>();
    @Autowired
    private UserService userService;
    @GetMapping("admin/getUnknown")
    public String getUnknown()
    {
        if(Login.user==null)
        {
            map.put("code",404);
            map.put("msg","你还没有登录！！");
            return JSON.toJSONString(map);
        }
        else if (!Login.user.getIdentity().equals("admin"))
        {
            map.put("code",404);
            map.put("msg","你不是管理员！！");
            return JSON.toJSONString(map);
        }
        else
        {
            map.put("code",200);
            map.put("msg","获取未通过信息成功");
            map.put("result",userService.getUnknown());
            return JSON.toJSONString(map);
        }
    }
    @PostMapping("admin/pass")
    public String pass(String id)
    {
        if(Login.user==null)
        {
            map.put("code",404);
            map.put("msg","你还没有登录！！");
            return JSON.toJSONString(map);
        }
        else if (!Login.user.getIdentity().equals("admin"))
        {
            map.put("code",404);
            map.put("msg","你不是管理员！！");
            return JSON.toJSONString(map);
        }
        else
        {
            Project project = userService.detailInfo(id);
            project.setStatus("pass");
            userService.updateProject(project);
            map.put("code", 200);
            map.put("msg", "该项目通过审核");
            map.put("result", project);
            return JSON.toJSONString(map);
        }
    }
    @PostMapping("admin/fail")
    public String fail(String id)
    {
        if(Login.user==null)
        {
            map.put("code",404);
            map.put("msg","你还没有登录！！");
            return JSON.toJSONString(map);
        }
        else if (!Login.user.getIdentity().equals("admin"))
        {
            map.put("code",404);
            map.put("msg","你不是管理员！！");
            return JSON.toJSONString(map);
        }
        else
        {
            Project project = userService.detailInfo(id);
            project.setStatus("fail");
            userService.updateProject(project);
            map.put("code", 200);
            map.put("msg", "该项目未通过审核！");
            map.put("result", project);
            return JSON.toJSONString(map);
        }
    }
    @PostMapping("admin/delete")
    public String delete(String id)
    {
        if(Login.user==null)
        {
            map.put("code",404);
            map.put("msg","你还没有登录！！");
            return JSON.toJSONString(map);
        }
        else if (!Login.user.getIdentity().equals("admin"))
        {
            map.put("code",404);
            map.put("msg","你不是管理员！！");
            return JSON.toJSONString(map);
        }
        else
        {
            map.put("result", userService.detailInfo(id));
            userService.deleteProject(id);
            map.put("code", 200);
            map.put("msg", "该项目已删除");
            return JSON.toJSONString(map);
        }
    }
}
