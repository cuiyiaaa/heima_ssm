package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.mapper.PermissionMapper;
import com.itheima.ssm.service.IPermissionService;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("permissionService")
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private PermissionMapper mapper;

    @Override
    public List<Permission> findPermissionAll(Integer page, Integer size) throws Exception {
        PageHelper.startPage(page, size);
        return mapper.findPermissionAll(page, size);
    }

    @Override
    public Permission findPermissionById(String permissionId) throws Exception {
        return mapper.findPermissionById(permissionId);
    }

    @Override
    public List<Permission> findRoleByIdAndPermission(String roleId) throws Exception {
        return mapper.findRoleByIdAndPermission(roleId);
    }

    @Override
    public void savePermission(Permission permission) throws Exception {
        mapper.savePermission(permission);
    }

}
