package com.example.mapper;

import com.example.entity.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper
{
    void addAccount(Account user);
}
