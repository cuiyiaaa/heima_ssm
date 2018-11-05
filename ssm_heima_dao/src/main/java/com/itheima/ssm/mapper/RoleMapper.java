package com.itheima.ssm.mapper;

import com.itheima.ssm.domain.Role;

import java.util.List;
import java.util.Map;

public interface RoleMapper {

    /**
     * 根据用户ID查询角色详细信息
     *
     * @param userId
     * @return
     */
    List<Role> findRoleByUserId(String userId);

    /**
     * 根据角色ID查询对应角色信息
     *
     * @param Id
     * @return
     * @throws Exception
     */
    Role findRoleById(String Id) throws Exception;

    /**
     * 根据权限ID获取与权限相关的角色信息
     *
     * @param id
     * @return
     */
    List<Role> findRoleByPermissionID(String id) throws Exception;

    /**
     * 查询所有角色信息
     *
     * @return
     */
    List<Role> findRoleAll();

    /**
     * 根据用户ID，查询该用户未关联的角色
     *
     * @param userId
     * @return
     * @throws Exception
     */
    List<Role> findUserByIdAndAllRole(String userId) throws Exception;

    /**
     * 添加角色
     *
     * @param role
     */
    void saveRole(Role role) throws Exception;

    /**
     * 为角色添加用户
     *
     * @param map
     */
    void addRoleToPermission(Map<String, Object> map);
}
