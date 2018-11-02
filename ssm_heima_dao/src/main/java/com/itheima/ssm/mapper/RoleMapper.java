package com.itheima.ssm.mapper;

import com.itheima.ssm.domain.Role;

import java.util.List;

public interface RoleMapper {

    List<Role> findRoleById(String userId);
}
