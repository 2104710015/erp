package com.eleadmin.SalesManagement.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.SalesManagement.customer.entity.Customer;
import com.eleadmin.SalesManagement.project.entity.Project;
import com.eleadmin.SalesManagement.project.param.ProjectParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2023-05-17 16:03:03
 */
public interface ProjectMapper extends BaseMapper<Project> {

    /**
     * 查询所有工程信息
     */
    List<Project> findAllProject();
    /**
     * 删除工程信息
     * @param projectId
     */
    void deleteProject(int projectId);

    /**
     * 更新工程信息
     * @param project
     */
    void updateProject(Project project);

    void addProject(Project project);


}