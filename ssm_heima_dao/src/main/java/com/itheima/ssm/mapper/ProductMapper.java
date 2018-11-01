package com.itheima.ssm.mapper;

import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {

    /**
     * 查询所有产品信息
     *
     * @return
     * @throws Exception
     */
    List<Product> findProductAll() throws Exception;

    /**
     * 保存数据
     * @param product
     * @return
     */
    int saveProduct(Product product);

    Product findProductById(String id);
}
