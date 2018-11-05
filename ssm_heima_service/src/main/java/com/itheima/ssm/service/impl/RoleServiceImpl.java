package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.mapper.RoleMapper;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("roleService")
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper mapper;

    @Override
    public List<Role> findRoleAll(Integer page, Integer size) throws Exception {
        PageHelper.startPage(page, size);
        return mapper.findRoleAll();
    }

    @Override
    public List<Role> findUserByIdAndAllRole(String userId) throws Exception {
        return mapper.findUserByIdAndAllRole(userId);
    }

    @Override
    public void saveRole(Role role) throws Exception {
        mapper.saveRole(role);
    }

    @Override
    public void addRoleToPermission(String roleId, List<String> permIds) {
        Map<String, Object> map = new HashMap<>();
        map.put("roleId", roleId);
        map.put("permIds", permIds);

        mapper.addRoleToPermission(map);
    }

    @Override
    public Role findRoleById(String id) throws Exception {
        return mapper.findRoleById(id);
    }
}
