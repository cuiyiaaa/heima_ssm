package com.itheima.ssm.service.impl;

import com.itheima.ssm.domain.Product;
import com.itheima.ssm.mapper.ProductMapper;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> findAll() throws Exception {
        return mapper.findAll();
    }
}
