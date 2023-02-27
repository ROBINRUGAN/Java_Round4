package com.example.entity;

import java.util.UUID;

public class Project
{
    private String id;
    private String account;
    private String name;
    private String tel;
    private String image;
    private String status;
    private Double money;
    private String content;
    private String title;

    public Project(String account,String name, String tel, String image,String content,String title)
    {
        this.id = UUID.randomUUID().toString();
        this.account = account;
        this.name = name;
        this.tel = tel;
        this.image = image;
        this.status = "unknown";
        this.money = 0.0;
        this.content = content;
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getAccount()
    {
        return account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public Double getMoney()
    {
        return money;
    }

    public void setMoney(Double money)
    {
        this.money = money;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getTel()
    {
        return tel;
    }

    public void setTel(String tel)
    {
        this.tel = tel;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }
}
