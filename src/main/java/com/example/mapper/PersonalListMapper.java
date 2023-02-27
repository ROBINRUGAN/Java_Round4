package com.example.mapper;

import com.example.entity.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonalListMapper
{
    List<Project> detailList(String account);

}
