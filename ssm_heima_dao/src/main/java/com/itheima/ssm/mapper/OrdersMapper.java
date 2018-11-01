package com.itheima.ssm.mapper;

import com.itheima.ssm.domain.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersMapper {

   /* @Select("SELECT * FROM orders")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "productId", property = "product", one = @One(select = "com.itheima.ssm.mapper.ProductMapper.findById"))
    }
    )*/
    List<Orders> findOrdersAll();



 /*   @Select("SELECT * FROM orders WHERE ID = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "productId", property = "product",javaType = Product.class,one = @One(select = "com.itheima.ssm.mapper.ProductMapper.findById")),
            @Result(column = "memberId", property = "member",javaType = Member.class, one = @One(select = "com.itheima.ssm.mapper.MemberMapper.findById")),
            @Result(column = "id", property = "travellers",javaType = List.class, many = @Many(select = "com.itheima.ssm.mapper.TravellerMapper.findById"))}
    )*/
    Orders findOrdersById(String id);
}
