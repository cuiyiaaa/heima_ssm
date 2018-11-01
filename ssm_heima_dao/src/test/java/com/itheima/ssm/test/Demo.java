package com.itheima.ssm.test;

import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.mapper.OrdersMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

    @Test
    public void test() {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
        OrdersMapper mapper = context.getBean(OrdersMapper.class);
        Orders orders = mapper.findOrdersById("5DC6A48DD4E94592AE904930EA866AFA");
        System.out.println(orders);
    }
}
