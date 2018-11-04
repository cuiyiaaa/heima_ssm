package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService service;

    /**
     * 查询所有角色信息
     *
     * @param page 当前页码
     * @param size 每页显示多少条
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", defaultValue = "1") Integer page, @RequestParam(name = "size", defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();

        List<Role> roleList = service.findRoleAll(page, size);
        PageInfo pageInfo = new PageInfo(roleList);

        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("role-list");
        return mv;
    }

    /**
     * 添加角色
     *
     * @param role
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    public String save(Role role) throws Exception {
        service.saveRole(role);

        return "redirect:findAll";
    }

    /**
     * 根据角色ID查询对应角色信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") String id) throws Exception {
        ModelAndView mv = new ModelAndView();

        Role role = service.findRoleById(id);
        mv.addObject("role", role);
        mv.setViewName("role-show");
        return mv;
    }
}
