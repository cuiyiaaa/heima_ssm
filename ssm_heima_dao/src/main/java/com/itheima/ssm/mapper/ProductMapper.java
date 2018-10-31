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
    @Select("SELECT * FROM product")
    List<Product> findAll() throws Exception;

    /**
     * 保存数据
     * @param product
     * @return
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    int saveProduct(Product product);


    @Select("SELECT * FROM product WHERE id=#{id}")
    Product findById(Insert id);
}
