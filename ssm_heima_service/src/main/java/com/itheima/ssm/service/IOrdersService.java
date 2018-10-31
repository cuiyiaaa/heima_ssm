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
    List<Orders> findAll(Integer page,Integer size) throws Exception;
}
