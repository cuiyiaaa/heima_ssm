package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IPermissionService;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IPermissionService permissionService;

    /**
     * 查询所有角色信息
     *
     * @param page 当前页码
     * @param size 每页显示多少条
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll")
    @RolesAllowed({"ADMIN", "USER"})
    public ModelAndView findAll(@RequestParam(name = "page", defaultValue = "1") Integer page, @RequestParam(name = "size", defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();

        List<Role> roleList = roleService.findRoleAll(page, size);
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
        roleService.saveRole(role);

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

        Role role = roleService.findRoleById(id);
        mv.addObject("role", role);
        mv.setViewName("role-show");
        return mv;
    }

    @RequestMapping("/findRoleByIdAndPermission/{roleId}")
    public String findRoleByIdAndPermission(Model model, @PathVariable(name = "roleId") String roleId) throws Exception {
        System.out.println(model.getClass());
        model.addAttribute("permissionList", permissionService.findRoleByIdAndPermission(roleId));
        model.addAttribute("roleId", roleId);
        return "role-permission-add";
    }

    /**
     * 为角色添加权限
     *
     * @param roleId
     * @param permIds
     * @return
     */
    @RequestMapping("/addRoleToPermission")
    public String addRoleToPermission(String roleId, @RequestParam("permIds") String[] permIds) {

        roleService.addRoleToPermission(roleId, Arrays.asList(permIds));

        return "redirect:findAll";
    }
}
