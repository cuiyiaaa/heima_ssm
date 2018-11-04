package com.itheima.ssm.service;

import com.itheima.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    /**
     * 查询所有的用户信息
     *
     * @param page 当前页码
     * @param size 每页显示多少条
     * @return
     * @throws Exception
     */
    List<UserInfo> findUserInfoAll(Integer page, Integer size) throws Exception;

    /**
     * 添加用户信息
     *
     * @param userInfo
     * @throws Exception
     */
    void saveUserInfo(UserInfo userInfo) throws Exception;

    /**
     * 根据ID查询对应用户信息
     * @param id
     * @return
     * @throws Exception
     */
    UserInfo findUserInfoById(String id) throws Exception;

}
