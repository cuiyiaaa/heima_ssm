package com.itheima.ssm.service;

import com.itheima.ssm.domain.Role;

import java.util.List;

public interface IRoleService {

    /**
     * 查询所有角色信息
     *
     * @return
     */
    List<Role> findRoleAll(Integer page, Integer size) throws Exception;

    /**
     * 添加角色信息
     *
     * @param role
     * @throws Exception
     */
    void saveRole(Role role) throws Exception;

    /**
     * 根据角色ID查询对应角色信息
     * @param id
     * @return
     * @throws Exception
     */
    Role findRoleById(String id) throws Exception;
}
