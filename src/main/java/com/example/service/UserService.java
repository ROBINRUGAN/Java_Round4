package com.example.service;

import com.example.entity.Account;
import com.example.entity.Project;
import com.example.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
    @Autowired
    public LoginMapper loginMapper;
    @Autowired
    public RegisterMapper registerMapper;
    @Autowired
    public ProjectMapper projectMapper;
    @Autowired
    public PersonalListMapper personalListMapper;
    @Autowired
    public DonationMapper donationMapper;
    @Autowired
    public DetailInfoMapper detailInfoMapper;
    @Autowired
    public AdminMapper adminMapper;

    //获得用户信息 (用于注册和登录)
    public Account getAccount(String username)
    {
        return loginMapper.getAccount(username);
    }

    public void addAccount(Account user)
    {
        registerMapper.addAccount(user);
    }

    public List<Project> showProjectList(Integer page)
    {   //分页查询，每页五条信息
        return projectMapper.showProjectList((page-1)*5);
    }

    public void uploadProject(Project project)
    {
        projectMapper.addProject(project);
    }

    public List<Project> detailList(String account)
    {
        return personalListMapper.detailList(account);
    }

    public Project detailInfo(String id)
    {
        return detailInfoMapper.detailInfo(id);
    }

    public List<Project> showProjectListAll()
    {
        return projectMapper.showProjectListAll();
    }

    public Project donation(String id, Double money)
    {
        Project project = detailInfoMapper.detailInfo(id);
        project.setMoney(project.getMoney()+money);
        donationMapper.updateProject(project);
        return project;
    }
    public void updateProject(Project project)
    {
        donationMapper.updateProject(project);
    }

    public List<Project> getUnknown()
    {
        return adminMapper.getUnknown();
    }

    public void deleteProject(String id)
    {
        adminMapper.deleteProject(id);
    }
}
