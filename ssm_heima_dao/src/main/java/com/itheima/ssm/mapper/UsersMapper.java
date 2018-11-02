package com.itheima.ssm.mapper;

import com.itheima.ssm.domain.UserInfo;

public interface UsersMapper {

    /**
     * 根据用户查询对应的用户信息
     * @param username
     * @return
     * @throws Exception
     */
    UserInfo findUserInfoByName(String username) throws Exception;
}
