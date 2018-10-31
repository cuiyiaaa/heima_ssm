package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {


    @Autowired
    private IProductService service;

    @RequestMapping("/findAll")
    public String findAll(Model model) throws Exception {
        List<Product> list = service.findAll();
        model.addAttribute("productList", list);

        return "product-list";
    }
}
