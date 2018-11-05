package com.itheima.ssm.mapper;

import com.itheima.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface UsersMapper {

    /**
     * 根据用户查询对应的用户信息
     *
     * @param username
     * @return
     * @throws Exception
     */
    UserInfo findUserInfoByName(String username) throws Exception;

    /**
     * 查询所有的用户信息
     *
     * @return
     * @throws Exception
     */
    List<UserInfo> findUserInfoAll() throws Exception;

    /**
     * 保存用户信息
     *
     * @param userInfo
     * @throws Exception
     */
    void saveUserInfo(UserInfo userInfo) throws Exception;

    /**
     * 根据ID查询用户的信息
     *
     * @param id
     * @return
     */
    UserInfo findUserInfoById(String id) throws Exception;

    /**
     * 根据角色ID查询对该角色下的用户
     *
     * @param roleId
     * @return
     * @throws Exception
     */
    List<UserInfo> findUserInfoByRoleId(String roleId) throws Exception;

    /**
     * 为用户添加角色
     * @param userId
     * @param roleIds
     * @throws Exception
     */
    void addRoleToUser(@Param("userId") String userId, @Param("roleIds") List<String> roleIds) throws Exception;
}
