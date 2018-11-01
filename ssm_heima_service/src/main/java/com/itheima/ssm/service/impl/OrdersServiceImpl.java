package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.mapper.OrdersMapper;
import com.itheima.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ordersService")
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private OrdersMapper mapper;

    @Override
    public List<Orders> findOrdersAll(Integer page, Integer size) throws Exception {
        //参数 pageNum是页码值，参数pageSize代表每页显示条数
        PageHelper.startPage(page, size);  //必须写在真正去调用分页代码之前
        return mapper.findOrdersAll();
    }

    @Override
    public Orders findOrdersById(String id) {
        return mapper.findOrdersById(id);
    }
}
