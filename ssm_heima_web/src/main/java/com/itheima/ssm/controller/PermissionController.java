package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService service;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", defaultValue = "1") Integer page, @RequestParam(name = "size", defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();

        PageInfo pageInfo = new PageInfo(service.findPermissionAll(page, size));

        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/save")
    public String save(Permission permission) throws Exception {
        service.savePermission(permission);

        return "redirect:findAll";
    }

    @RequestMapping("/findById/{permissionId}")
    public ModelAndView findById(@PathVariable("permissionId") String permissionId) throws Exception {
        ModelAndView mv = new ModelAndView();

        mv.addObject("permission", service.findPermissionById(permissionId));
        mv.setViewName("permission-show");
        return mv;
    }
}
