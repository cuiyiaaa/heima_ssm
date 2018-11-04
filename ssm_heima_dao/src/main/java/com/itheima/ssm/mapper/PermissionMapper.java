package com.itheima.ssm.mapper;

import com.itheima.ssm.domain.Permission;
import org.omg.CORBA.portable.ValueOutputStream;

import java.util.List;

public interface PermissionMapper {

    /**
     * 根据角色id查询，角色下的所有权限
     *
     * @param id
     * @return
     * @throws Exception
     */
    List<Permission> findPermissionByRoleId(String id) throws Exception;

    /**
     * 查询所有权限信息
     *
     * @return
     * @throws Exception
     */
    List<Permission> findPermissionAll(Integer page, Integer size) throws Exception;

    /**
     * 根据权限ID获取对应的权限信息
     *
     * @param id
     * @return
     */
    Permission findPermissionById(String permissionId);

    /**
     * 添加操作
     *
     * @param permission
     * @throws Exception
     */
    void savePermission(Permission permission) throws Exception;
}
