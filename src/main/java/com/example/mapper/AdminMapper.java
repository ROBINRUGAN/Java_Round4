package com.example.mapper;
import com.example.entity.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper
{
    List<Project> getUnknown();

    void deleteProject(String id);
}
