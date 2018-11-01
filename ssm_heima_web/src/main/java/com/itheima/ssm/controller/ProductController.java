package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService service;

    /**
     * 查询所有的产品信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();

        //查询产品信息，并存入ModelAndView中
        List<Product> list = service.findProductAll(page, size);

        PageInfo pageInfo = new PageInfo(list);
        System.out.println(pageInfo);
        mv.addObject("pageInfo", pageInfo);

        //跳转到product-list页面
        mv.setViewName("product-list");
        return mv;
    }

    /**
     * 添加产品信息
     *
     * @param product 在需要校验的pojo前边添加@@Validated，在需要校验的pojo后添加BindingResult ，BindingResult接收校验出错的信息
     *                注意:@Validated 和 BindingResult 是配对出现的，并且形参顺序是固定的(一前一后)
     */
    @RequestMapping("/save")
    public String save(Product product) {
        service.saveProduct(product);
        return "redirect:findAll";
    }

}






























