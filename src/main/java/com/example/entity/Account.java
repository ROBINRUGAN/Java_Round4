package com.example.entity;

public class Account
{
    private String username;
    private String password;
    private String email;

    private String identity;

    public Account(String username, String password, String email, String identity)
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.identity = identity;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getIdentity()
    {
        return identity;
    }

    public void setIdentity(String identity)
    {
        this.identity = identity;
    }
}
