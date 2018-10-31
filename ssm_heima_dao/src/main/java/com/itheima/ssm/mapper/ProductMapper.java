package com.itheima.ssm.mapper;

import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {

    /**
     * 查询所有产品信息
     * @return
     * @throws Exception
     */
    @Select("SELECT * FROM product")
    List<Product> findAll() throws Exception;
}
