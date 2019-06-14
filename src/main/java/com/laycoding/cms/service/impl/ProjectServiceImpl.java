package com.laycoding.cms.service.impl;

import com.laycoding.cms.mapper.ProjectMapper;
import com.laycoding.cms.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Resource
    private ProjectMapper projectMapper;
    @Override
    public List<String> getProjects() {
        return projectMapper.getProjects();
    }
}
