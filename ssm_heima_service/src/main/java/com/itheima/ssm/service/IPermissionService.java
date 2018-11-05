package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;

import java.util.List;

public interface IPermissionService {

    /**
     * 查询所有权限信息
     *
     * @return
     */
    List<Permission> findPermissionAll(Integer page, Integer size) throws Exception;

    /**
     * 根据权限ID获取对应的权限信息
     *
     * @param permissionId
     * @return
     * @throws Exception
     */
    Permission findPermissionById(String permissionId) throws Exception;

    List<Permission> findRoleByIdAndPermission(String roleId) throws Exception;

    /**
     * 添加
     *
     * @param permission
     * @throws Exception
     */
    void savePermission(Permission permission) throws Exception;

}
