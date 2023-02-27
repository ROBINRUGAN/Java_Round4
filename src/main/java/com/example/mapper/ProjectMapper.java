package com.example.mapper;

import com.example.entity.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ProjectMapper
{
    List<Project> showProjectList(Integer page);

    void addProject(Project project);

    List<Project> showProjectListAll();
}
