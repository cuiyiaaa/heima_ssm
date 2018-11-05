package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", defaultValue = "1") Integer page, @RequestParam(name = "size", defaultValue = "10") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();

        PageInfo pageInfo = new PageInfo(sysLogService.findSysLogAll(page, size));
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("syslog-list");

        return mv;
    }
}
