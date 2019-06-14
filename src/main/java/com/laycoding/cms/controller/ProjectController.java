package com.laycoding.cms.controller;

import com.laycoding.cms.service.ProjectService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sys/project")
public class ProjectController {
    @Resource
    private ProjectService projectService;
    @RequestMapping(value = "/getProjects")
    public List<String> getProjects(){
        List<String> list=projectService.getProjects();
        return list;
    }
}
