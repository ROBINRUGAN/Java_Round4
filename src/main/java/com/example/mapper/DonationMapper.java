package com.example.mapper;

import com.example.entity.Project;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DonationMapper
{

    void updateProject(Project project);
}
