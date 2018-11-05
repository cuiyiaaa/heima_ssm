package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IRoleService;
import com.itheima.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();

        //获取用户所有信息
        List<UserInfo> userList = userService.findUserInfoAll(page, size);

        //存入PageHelper分页中
        PageInfo pageInfo = new PageInfo(userList);

        //将用户信息存入request域
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save")
    public String save(UserInfo userInfo) throws Exception {
        userService.saveUserInfo(userInfo);
        return "redirect:findAll";
    }

    @RequestMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") String id) throws Exception {
        ModelAndView mv = new ModelAndView();

        //根据id查询用户信息
        UserInfo userInfo = userService.findUserInfoById(id);

        mv.addObject("user", userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/findUserByIdAndAllRole/{userId}")
    public ModelAndView findUserByIdAndAllRole(@PathVariable("userId") String userId) throws Exception {
        ModelAndView mv = new ModelAndView();

        //查询角色
        mv.addObject("roleList", roleService.findUserByIdAndAllRole(userId));
        //将用户ID回写到页面
        mv.addObject("userId", userId);

        mv.setViewName("user-role-add");
        return mv;
    }


    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(String userId, @RequestParam(name = "roleIds", required = true) String[] roleIds) throws Exception {

        userService.addRoleToUser(userId, Arrays.asList(roleIds));

        return "redirect:findAll";
    }

    @RequestMapping("/test")
    public void test(HttpServletRequest request) {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(userDetails.getUsername());
        System.out.println(userDetails.getPassword());
        userDetails.getAuthorities().forEach(ele -> System.out.println(ele.getAuthority()));

        System.out.println("============================");
        SecurityContextImpl securityContextImpl = (SecurityContextImpl) request
                .getSession().getAttribute("SPRING_SECURITY_CONTEXT");
        // 登录名
        System.out.println("Username:" + securityContextImpl.getAuthentication().getName());

        // 登录密码，未加密的  获取不到
        System.out.println("Credentials:" + securityContextImpl.getAuthentication().getCredentials());

        WebAuthenticationDetails details = (WebAuthenticationDetails) securityContextImpl.getAuthentication().getDetails();
        // 获得访问IP
        System.out.println("RemoteAddress" + details.getRemoteAddress());

        // 获得sessionid
        System.out.println("SessionId" + details.getSessionId());

        // 获得当前用户所拥有的权限
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) securityContextImpl.getAuthentication().getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            System.out.println("Authority" + grantedAuthority.getAuthority());
        }
    }
}
