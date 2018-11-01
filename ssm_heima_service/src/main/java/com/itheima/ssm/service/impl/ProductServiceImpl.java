package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.mapper.ProductMapper;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> findProductAll(Integer page, Integer size) throws Exception {
        PageHelper.startPage(page, size);
        return mapper.findProductAll();
    }

    @Override
    public boolean saveProduct(Product product) {
        return mapper.saveProduct(product) > 0;
    }
}
