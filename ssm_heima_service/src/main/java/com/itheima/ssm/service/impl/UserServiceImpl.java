package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.mapper.UsersMapper;
import com.itheima.ssm.service.IUserService;
import com.itheima.ssm.utils.BCryptPasswordEncoderUtils;
import org.omg.CORBA.MARSHAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UsersMapper mapper;

    //密码加密类
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<UserInfo> findUserInfoAll(Integer page, Integer size) throws Exception {
        PageHelper.startPage(page, size);
        return mapper.findUserInfoAll();
    }

    @Override
    public void saveUserInfo(UserInfo userInfo) throws Exception {
        //将密码加密
        String encodePwd = bCryptPasswordEncoder.encode(userInfo.getPassword());
        userInfo.setPassword(encodePwd);

        mapper.saveUserInfo(userInfo);
    }

    @Override
    public UserInfo findUserInfoById(String id) throws Exception {
        return mapper.findUserInfoById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        try {
            //根据用户名查询对应的用户信息
            UserInfo userInfo = mapper.findUserInfoByName(username);

            /**
             * String username：用户名
             * String password：密码
             * boolean enabled：账户是否可用
             * boolean accountNonExpired:是否忽略账户，false为忽略
             * boolean credentialsNonExpired ：账户是否过期，false为过期
             * boolean accountNonLocked：账户是否锁定。false为锁定
             * Collection<? extends GrantedAuthority> authorities：用户的角色信息集合
             */
            //将用户信息存入Spring Security框架的User中
            user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 1, true, true, true, getAuthority(userInfo.getRoleList()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    private Collection<? extends GrantedAuthority> getAuthority(List<Role> roleList) {
        //组装用户的权限信息
        List<GrantedAuthority> list = new ArrayList<>();
        for (Role role : roleList) {
            list.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return list;
    }
}
