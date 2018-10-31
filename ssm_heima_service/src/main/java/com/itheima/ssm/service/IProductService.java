package com.itheima.ssm.service;

import com.itheima.ssm.domain.Product;

import java.util.List;

public interface IProductService {

    /**
     * 查询所有产品信息
     *
     * @return
     * @throws Exception
     */
    List<Product> findAll(Integer page, Integer size) throws Exception;

    /**
     * 添加产品信息
     *
     * @param product
     * @return
     */
    boolean saveProduct(Product product);
}
