package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService service;

    @RequestMapping("/findAll")
    @Secured("ROLE_ADMIN") //使用该注解前缀必须是ROLE_
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();

        List<Orders> list = service.findOrdersAll(page, size);

        //pageInfo就是一个分页的bean
        PageInfo pageInfo = new PageInfo(list);
        System.out.println(pageInfo);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }

    /**
     * 根据订单id 查询订单详细信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") String id) {
        ModelAndView mv = new ModelAndView();

        //查询订单详细信息
        Orders orders = service.findOrdersById(id);
        //将订单信息存入request域中
        mv.addObject("orders", orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
