package com.itheima.ssm.service;

import com.itheima.ssm.domain.Orders;

import java.util.List;

public interface IOrdersService {
    /**
     * 分页查询，
     * @param page 当前页码
     * @param size 每页显示多少条数据
     * @return
     * @throws Exception
     */
    List<Orders> findOrdersAll(Integer page,Integer size) throws Exception;

    /**
     * 根据ID对应的订单详情
     * @param id
     * @return
     */
    Orders findOrdersById(String id);
}
